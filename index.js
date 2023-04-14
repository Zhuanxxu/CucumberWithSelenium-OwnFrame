const report = require('multiple-cucumber-html-reporter');
const os = require('os');
const sistemaOperativo = os.platform();
const versionSistemaOperativo = os.release();
const json = require('./contextTestInfo.json');




report.generate({
    jsonDir: './reports/',
    reportPath: './reports/',
    openReportInBrowser: true,
    displayDuration:true,
    displayReportTime:true,
    metadata: {
        browser: {
            name: json.BrowserName,
            version: json.BrowserVersion
        },
        device: 'Local test machine',
        platform: {
            name: sistemaOperativo,
            version: versionSistemaOperativo
        }
    },
    customData: {
        title: 'Run info',
        data: [
            {label: 'Project', value: 'Framework QA Automation'},
            {label: 'Release', value: '1.0'}
        ]
    }
});