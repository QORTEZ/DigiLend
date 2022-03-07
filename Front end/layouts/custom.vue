<template>
<div>
    <header class="navbar-light navbar-sticky">
	<!-- Logo Nav START -->
	<nav class="navbar navbar-expand-lg">
		<div class="container">
			<!-- Logo START -->
			<nuxt-link class="navbar-brand me-0 fw-b" to="/">
				Digilend
			</nuxt-link>
			<!-- Logo END -->

			<!-- Responsive navbar toggler -->
			<button class="navbar-toggler ms-auto" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-animation">
					<span></span>
					<span></span>
					<span></span>
				</span>
			</button>

			<!-- Main navbar START -->
			<div class="navbar-collapse collapse" id="navbarCollapse">

				<!-- Nav Search END -->
				<ul class="navbar-nav navbar-nav-scroll mx-auto">
					<li class="nav-item"><nuxt-link class="nav-link" to="/">Home</nuxt-link></li>
					<li v-if="!(getPriv('ROLE_CUSTOMER') && getPriv('ROLE_ADMIN') && getPriv('ROLE_CUSTOMER'))" class="nav-item"><nuxt-link class="nav-link" to="customer">Customer Dashboard</nuxt-link></li>
					<li v-if="getPriv('ROLE_ADMIN') && userLoggedIn" class="nav-item"><nuxt-link class="nav-link" to="admin">Admin Dashboard</nuxt-link></li>
				</ul>
			</div>
			<!-- Main navbar END -->
			<div class="navbar-nav ms-2 flex" v-if="!userLoggedIn">
				<nuxt-link to="/auth/sign-in" class="btn btn-sm btn-dark" style="margin-right: 15px;"><i class="bi bi-power me-2"></i>Sign In</nuxt-link>
				<nuxt-link to="/auth/sign-up" class="btn btn-sm btn-dark "><i class="bi bi-power me-2"></i>Sign Up</nuxt-link>
			</div>
			<div class="navbar-nav ms-2" v-if="userLoggedIn">
				<button @click="logOutUser" class="btn btn-sm btn-dark mb-0"><i class="bi bi-power me-2"></i>Log out</button>
				<!-- <button class="btn btn-sm btn-dark mb-0"><i class="bi bi-power me-2"></i>Sign UP</button> -->
			</div>

		</div>
	</nav>
	<!-- Logo Nav END -->
</header>

    <Nuxt />

</div>
</template>
<script>
export default {
	data(){
		return{
			userLoggedIn: false,
			currentUser: this.$cookiz.get('user1') ?  this.$cookiz.get('user1') : null
		}
	},
	mounted() {
		this.userLoggedInFn()
	},
	computed: {

	},

	methods: {
		async getPriv(priv) {
			if (this.currentUser) {

				this.currentUser?.data?.roles.includes(priv)
			}
		},
		userLoggedInFn() {
			if (this.currentUser) {
				this.userLoggedIn =  true
			}  else {
				this.userLoggedIn =  false
			}
		},

		async logOutUser() {
			this.$cookiz.removeAll()
			this.userLoggedIn =  false

		}


	}
}
</script>