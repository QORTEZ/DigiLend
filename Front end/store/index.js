// const user_r = this.$cookiz.get('user1')
export const state = (app) => ({
    userLoggedIn: null
})

export const getters = {
    isAuthenticated(state) {
        return state.auth.loggedIn
    },

    loggedInUser(state) {
        return state.auth.user
    }
}