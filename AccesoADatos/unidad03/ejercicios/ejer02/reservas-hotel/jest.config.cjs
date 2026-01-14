module.exports = { preset: 'ts-jest', testEnvironment: 'node', testMatch: ['**/tests/**/*.test.ts'] ,
  reporters: ['default', '<rootDir>/nota-reporter.js']
};
