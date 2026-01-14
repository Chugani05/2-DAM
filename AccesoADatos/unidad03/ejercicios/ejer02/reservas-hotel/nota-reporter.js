const fs = require("fs");
const path = require("path");

function loadConfig() {
  const cfgPath = path.resolve(process.cwd(), "nota-config.json");
  if (fs.existsSync(cfgPath)) {
    return JSON.parse(fs.readFileSync(cfgPath, "utf-8"));
  }
  // fallback
  return {};
}

function matchAny(testPath, patterns) {
  const norm = testPath.split(path.sep).join("/");
  return patterns.some(p => norm.endsWith(p));
}

class NotaReporter {
  onRunComplete(_, results) {
    const cfg = loadConfig();

    const perTestFile = results.testResults.map(tr => ({
      file: tr.testFilePath,
      total: tr.numFailingTests + tr.numPassingTests,
      passed: tr.numPassingTests,
      failed: tr.numFailingTests
    }));

    const ejercicios = {};
    let puntosObtenidos = 0;
    let puntosMax = 0;

    for (const [key, meta] of Object.entries(cfg)) {
      const patterns = meta.patterns || [];
      const puntos = Number(meta.points || 0);
      puntosMax += puntos;

      const files = perTestFile.filter(f => matchAny(f.file, patterns));
      const total = files.reduce((a, f) => a + f.total, 0);
      const passed = files.reduce((a, f) => a + f.passed, 0);
      const failed = files.reduce((a, f) => a + f.failed, 0);

      const ratio = total === 0 ? 0 : passed / total;
      const earned = Math.round(puntos * ratio * 1000) / 1000;

      puntosObtenidos += earned;

      ejercicios[key] = {
        puntosMax: puntos,
        tests: { total, passed, failed },
        ratio: Math.round(ratio * 1000) / 1000,
        puntosObtenidos: earned,
        archivos: files.map(f => path.basename(f.file))
      };
    }

    // nota sobre 10 (si puntosMax=0, usar 0)
    const nota10 = puntosMax === 0 ? 0 : Math.round((puntosObtenidos / puntosMax) * 10 * 100) / 100;

    const nota = {
      puntosMax,
      puntosObtenidos: Math.round(puntosObtenidos * 1000) / 1000,
      notaSobre10: nota10,
      resumenTests: {
        total: results.numTotalTests,
        passed: results.numPassedTests,
        failed: results.numFailedTests
      },
      ejercicios
    };

    fs.writeFileSync("nota.json", JSON.stringify(nota, null, 2));

    const lines = [];
    lines.push(`Nota final: ${nota10}/10`);
    lines.push(`Puntos: ${nota.puntosObtenidos}/${nota.puntosMax}`);
    lines.push(`Tests: ${nota.resumenTests.passed}/${nota.resumenTests.total}`);
    lines.push("");
    for (const [k, v] of Object.entries(ejercicios)) {
      lines.push(`${k}: ${v.puntosObtenidos}/${v.puntosMax}  (tests ${v.tests.passed}/${v.tests.total})`);
    }
    lines.push("");
    fs.writeFileSync("nota.txt", lines.join("\n"));
  }
}

module.exports = NotaReporter;
