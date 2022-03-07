export default function({
    redirect,
    app
}) {
    if (!app.$cookiz.get('user1')) {

        redirect('/auth/sign-in')
    }
}