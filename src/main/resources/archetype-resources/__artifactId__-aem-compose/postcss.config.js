module.exports = ({ env }) => ({
  plugins: {
    'postcss-pxtorem': {
      rootValue: 16,
      unitPrecision: 5,
      propList: [
        'bottom',
        'font',
        'font-size',
        'height',
        'left',
        'line-height',
        'margin*',
        'padding*',
        'right',
        'top',
        '*width',
      ],
      selectorBlackList: ['html'],
      replace: true
    },
    'postcss-sorting': {},
    autoprefixer: {
      grid: 'autoplace',
    },
    cssnano: env === 'production' ? true : false
  }
});
