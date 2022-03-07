<template>
    <main>
	<section class="p-0 d-flex align-items-center position-relative overflow-hidden">

		<div class="container-fluid">
			<div class="row">
				<!-- left -->
				<div class="col-12 col-lg-6 d-md-flex align-items-center justify-content-center bg-primary bg-opacity-10 vh-lg-100">
					<div class="p-3 p-lg-5">
						<!-- Title -->
						<div class="text-center">
							<h2 class="fw-bold">Welcome to Digilend</h2>
						</div>
					</div>
				</div>

				<!-- Right -->
				<div class="col-12 col-lg-6 m-auto">
					<div class="row my-5">
						<div class="col-sm-10 col-xl-8 m-auto">
							<!-- Title -->
							<span class="mb-0 fs-1">👋</span>
							<h1 class="fs-2">Login into Digilend!</h1>
							<p class="lead mb-4">Nice to see you! Please log in with your account.</p>

							<!-- Form START -->
							<form method="post" @submit.prevent="login">
								<!-- Email -->
								<div class="mb-4">
									<label for="exampleInputPhone" class="form-label">Phone number *</label>
									<div class="input-group input-group-lg">
										<span class="input-group-text bg-light rounded-start border-0 text-secondary px-3"><i class="bi bi-phone-fill"></i></span>
										<input v-model="phonenumber" type="text" class="form-control border-0 bg-light rounded-end ps-1" placeholder="phone number" id="exampleInputPhone">
									</div>
								</div>
								<!-- Password -->
								<div class="mb-4">
									<label for="inputPassword5" class="form-label">Password *</label>
									<div class="input-group input-group-lg">
										<span class="input-group-text bg-light rounded-start border-0 text-secondary px-3"><i class="fas fa-lock"></i></span>
										<input v-model="password" type="password" class="form-control border-0 bg-light rounded-end ps-1" placeholder="password" id="inputPassword5">
									</div>
									<div id="passwordHelpBlock" class="form-text">
										Your password must be 8 characters at least
									</div>
								</div>

								<!-- Button -->
								<div class="align-items-center mt-0">
									<div class="d-grid">
										<button type="submit" class="btn btn-primary mb-0">Login</button>
									</div>
								</div>
							</form>

							<!-- Sign up link -->
							<div class="mt-4 text-center">
								<span>Don't have an account? <nuxt-link to="sign-up"> Sign-up here</nuxt-link></span>
							</div>
						</div>
					</div> <!-- Row END -->
				</div>
			</div> <!-- Row END -->
		</div>
	</section>
</main>
</template>
<script>
export default {

  data() {
    return {
      phonenumber: '',
      password: '',
      error: null,
    };
  },

  methods: {
    async login() {
      try {
        await this.$auth.loginWith('local', {
          data: {
            username: this.phonenumber,
            password: this.password,
          },
        }).then((res) => {
			this.$cookiz.set('user1', res.data)
		});

        this.$router.push('/');
      } catch (e) {
		  console.log('err', e)
        // this.error = e.response.data.message;
      }
    },
  },
};
</script>