export const logout = () => {
    const user_r = JSON.parse(localStorage.getItem('currentUser'))
    return user_r
}
export const currentUser = () => {
    const user_r = JSON.parse(localStorage.getItem('currentUser'))
    return user_r
}
export const cookiesUser = () => {
    if (this.$cookiz.get('user1')) {
        return true
    }
}
export const logInUser = (user) => {
    localStorage.setItem('currentUser', JSON.stringify(user))
    localStorage.getItem('currentUser')
    const user_r = JSON.parse(localStorage.getItem('currentUser'))
    return user_r

}
export const checkUserLoggedIn = () => {
    return localStorage.getItem('currentUser') ? true : false
}


export default checkUserLoggedIn