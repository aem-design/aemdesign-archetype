/* eslint-disable */
const { getIfUtils, removeEmpty }                          = require('webpack-config-utils')
const { DefinePlugin, LoaderOptionsPlugin, ProvidePlugin } = require('webpack')

const CleanWebpackPlugin      = require('clean-webpack-plugin')
const CopyWebpackPlugin       = require('copy-webpack-plugin')
const EventHooksPlugin        = require('event-hooks-webpack-plugin')
const ImageminPlugin          = require('imagemin-webpack-plugin').default
const LodashPlugin            = require('lodash-webpack-plugin')
const OptimizeCSSAssetsPlugin = require('optimize-css-assets-webpack-plugin')
const TsconfigPathsPlugin     = require('tsconfig-paths-webpack-plugin')
const UglifyJsPlugin          = require('uglifyjs-webpack-plugin')
const exec                    = require('child_process').exec
const { relative, resolve }   = require('path')

const config = require('./config.json')

const PUBLIC_PATH = resolve(__dirname, 'public')
const SOURCE_PATH = resolve(__dirname, 'source')

const DEFAULT_APPSFOLDER = 'aemdesign'
const DEFAULT_PROJECT = 'aemdesign'

module.exports = env => {
  const { ifDev, ifProd } = getIfUtils(env)

  if (!env.project) {
    console.log("Specify a project when running webpack eg --env.project=" + DEFAULT_PROJECT)
    return
  }

  const PUBLIC_PATH_AEM = `/apps/${env.appFolder || DEFAULT_APPSFOLDER}/clientlibs`

  const project = config[env.project]

  return {
    context : SOURCE_PATH,
    devtool : ifDev('inline-source-map'),
    mode    : env.dev === true ? 'development' : 'production',

    entry: {
      [project.outputName]: [
        `./${env.project}/js/${project.entryFile.js}`,
        `./${env.project}/scss/${project.entryFile.sass}`,
      ],

      ...project.additionalEntries,
    },

    output: {
      filename      : 'js/[name].js',
      chunkFilename : 'js/[name].[chunkhash].js',
      path          : resolve(PUBLIC_PATH, env.project),
      publicPath    : PUBLIC_PATH_AEM,
    },

    module: {
      rules: [
        {
          test: /\.s(a|c)ss$/,

          use: [
            {
              loader: 'file-loader',

              options: {
                name: 'css/[name].css',
              },
            },
            {
              loader: 'extract-loader',
            },
            {
              loader: 'css-loader',

              options: {
                importLoaders : 1,
                sourceMap     : env.dev === true,
              },
            },
            {
              loader: 'postcss-loader',

              options: {
                ident     : 'postcss',
                sourceMap : env.dev === true,

                config: {
                  path: resolve('postcss.config.js'),

                  ctx: {
                    prod: env.prod === true,
                  },
                },
              },
            },
            {
              loader: 'sass-loader',

              options: {
                // implementation : require('sass'),
                outputStyle    : env.dev === true ? 'expanded' : 'compressed',
                precision      : 8,
                sourceMap      : env.dev === true,
              },
            },
          ],
        },
        {
          exclude : [resolve('node_modules')],
          test    : /\.(j|t)sx?$/,

          use: removeEmpty([
            {
              loader: 'babel-loader',
            },
            {
              loader: 'ts-loader',
            },
          ]),
        },
        {
          enforce : 'pre',
          exclude : [resolve('node_modules'), resolve('source/v1')],
          test    : /\.js$/,
          use     : ['eslint-loader'],
        },
        {
          enforce : 'pre',
          test    : /\.js$/,
          use     : ['source-map-loader'],
        },
        {
          test: require.resolve('jquery'),

          use: [
            {
              loader  : 'expose-loader',
              options : 'jQuery',
            },
            {
              loader  : 'expose-loader',
              options : '$',
            }
          ],
        },
        {
          test: /\.(png|jpg|gif|eot|ttf|svg|woff|woff2)$/,

          use: [
            {
              loader: 'file-loader',
              options: {
                context    : `source/${env.project}`,
                emitFile   : env.dev === true,
                name       : '[path][name].[ext]',
                publicPath : (_, resourcePath, context) => `../${relative(context, resourcePath)}`,
              },
            },
          ],
        },
      ],
    },

    optimization: {
      minimizer: [
        new UglifyJsPlugin({
          cache     : true,
          parallel  : true,
          sourceMap : env.dev === true,

          uglifyOptions: {
            ecma     : 6,
            mangle   : false,
            warnings : false,

            compress: {
              drop_console : true,
              warnings     : false,
            },

            output: {
              beautify: false,
              comments: false,
            },
          },
        }),
        new OptimizeCSSAssetsPlugin({
          canPrint     : true,
          cssProcessor : require('cssnano'),

          cssProcessorPluginOptions: {
            preset: ['default', {
              discardComments: {
                removeAll: true,
              },
            }],
          },
        }),
      ],

      splitChunks: {
        cacheGroups: {
          default: false,
          vendors: false,
        },
      },
    },

    plugins: removeEmpty([
      env.clean === true ? new CleanWebpackPlugin([PUBLIC_PATH]) : undefined,
      new CopyWebpackPlugin([
        {
          context : resolve(SOURCE_PATH, env.project),
          from    : './*.ico',
          to      : resolve(PUBLIC_PATH, env.project),
        },
        {
          context : resolve(SOURCE_PATH, env.project, 'resources/images'),
          from    : './**/*.*',
          to      : resolve(PUBLIC_PATH, env.project, 'resources/images'),
        },
        {
          context : resolve(SOURCE_PATH, env.project, 'resources/fonts'),
          from    : './**/*.*',
          to      : resolve(PUBLIC_PATH, env.project, 'resources/fonts'),
        },
        {
          context : resolve(SOURCE_PATH, env.project, 'css'),
          from    : './*.css',
          to      : resolve(PUBLIC_PATH, env.project, 'css'),
        },
      ]),
      new ImageminPlugin({
        test: /\.(jpe?g|png|gif|svg)$/i,
      }),
      new LodashPlugin({
        collections : true,
        shorthands  : true,
      }),
      new ProvidePlugin({
        FastClick       : 'fastclick',
        ObjectFitImages : 'object-fit-images',
        PubSub          : 'pubsub-js',

        // Expose the Bootstrap modules to the global namespace
        // https://github.com/shakacode/bootstrap-loader#bootstrap-4-internal-dependency-solution
        Popper          : ['popper.js', 'default'],
        Alert           : 'exports-loader?Alert!bootstrap/js/dist/alert',
        Button          : 'exports-loader?Button!bootstrap/js/dist/button',
        Carousel        : 'exports-loader?Carousel!bootstrap/js/dist/carousel',
        Collapse        : 'exports-loader?Collapse!bootstrap/js/dist/collapse',
        Dropdown        : 'exports-loader?Dropdown!bootstrap/js/dist/dropdown',
        Modal           : 'exports-loader?Modal!bootstrap/js/dist/modal',
        Popover         : 'exports-loader?Popover!bootstrap/js/dist/popover',
        Scrollspy       : 'exports-loader?Scrollspy!bootstrap/js/dist/scrollspy',
        Tab             : 'exports-loader?Tab!bootstrap/js/dist/tab',
        Tooltip         : 'exports-loader?Tooltip!bootstrap/js/dist/tooltip',
        Util            : 'exports-loader?Util!bootstrap/js/dist/util',
      }),
      ifProd(new LoaderOptionsPlugin({
        minimize: true,
      })),
      ifProd(new DefinePlugin({
        'process.env': {
          NODE_ENV: JSON.stringify('production'),
        },
      })),
      ifDev(new DefinePlugin({
        'process.env': {
          NODE_ENV: JSON.stringify('development'),
        },
      })),
      new EventHooksPlugin({
        done() {
          if (env.deploy) {
            const child = exec(`./deploy-front-end ${env.project}`)

            child.stdout.on('data', data => process.stdout.write(data))
            child.stderr.on('data', data => process.stderr.write(data))
          }
        },
      }),
    ]),

    resolve: {
      extensions: ['.webpack.js', '.web.js', '.ts', '.tsx', '.js'],

      plugins: [
        new TsconfigPathsPlugin(),
      ],
    },
  }
}
/* eslint-enable */
