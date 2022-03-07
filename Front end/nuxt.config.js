export default {
    // Global page headers: https://go.nuxtjs.dev/config-head
    head: {
        title: 'test-app',
        htmlAttrs: {
            lang: 'en',
        },
        meta: [
            { charset: 'utf-8' },
            { name: 'viewport', content: 'width=device-width, initial-scale=1' },
            { hid: 'description', name: 'description', content: '' },
            { name: 'format-detection', content: 'telephone=no' },
        ],
        link: [{ rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }],
    },

    // Global CSS: https://go.nuxtjs.dev/config-css
    css: [
        { src: '~/static/assets/vendor/font-awesome/css/all.min.css', lang: 'css' },
        { src: '~/static/assets/vendor/bootstrap-icons/bootstrap-icons.css', lang: 'css' },
        { src: '~/static/assets/vendor/tiny-slider/tiny-slider.css', lang: 'css' },
        { src: '~/static/assets/vendor/aos/aos.css', lang: 'css' },
        { src: '~/static/assets/css/style.css', lang: 'css' }
    ],


    plugins: [
        { src: '~/static/assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js', mode: 'client' },
        { src: '~/static/assets/vendor/tiny-slider/tiny-slider.js', mode: 'client' },
        { src: '~/static/assets/vendor/aos/aos.js', mode: 'client' },
    ],

    // Auto import components: https://go.nuxtjs.dev/config-components
    components: true,

    // Modules for dev and build (recommended): https://go.nuxtjs.dev/config-modules
    buildModules: [],

    // Modules: https://go.nuxtjs.dev/config-modules
    modules: [
        '@nuxtjs/axios',
        '@nuxtjs/auth-next', ['cookie-universal-nuxt', { alias: 'cookiz' }]
    ],

    // Axios module configuration: https://go.nuxtjs.dev/config-axios
    axios: {
        // Workaround to avoid enforcing hard-coded localhost:3000: https://github.com/nuxt-community/axios-module/issues/308
        baseURL: 'http://157.245.41.115/api',
    },

    // Build Configuration: https://go.nuxtjs.dev/config-build
    build: {},

    router: {
        middleware: 'guest'
    },

    auth: {
        strategies: {
            local: {
                token: {
                    property: 'token',
                    global: true,
                    // required: true,
                    type: 'Bearer'
                },
                user: {
                    property: 'user',
                    autoFetch: false
                },
                endpoints: {
                    login: { url: '/auth/signin', method: 'post' },
                    logout: { url: '/auth/logout', method: 'post' },
                    user: { url: '/auth/user', method: 'get' }
                }
            }
        }
    }
}