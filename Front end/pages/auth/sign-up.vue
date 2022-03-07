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
				<div class="col-12 col-lg-6">
					<div class="row my-4">
						<div class="col-sm-10 col-xl-8 m-auto">
							<!-- Title -->
							<h2>Sign up for your account!</h2>

							<!-- Form START -->
							<form method="post" @submit.prevent="register">

								<!-- First name -->
								<div class="mb-4">
									<label for="exampleInputFirstName" class="form-label">First name *</label>
									<div class="input-group input-group-lg">
										<span class="input-group-text bg-light rounded-start border-0 text-secondary px-3"><i class="bi bi-layout-text-sidebar"></i></span>
										<input v-model="firstName" type="text" class="form-control border-0 bg-light rounded-end ps-1" placeholder="first name" id="exampleInputFirstName">
									</div>
								</div>

								<!-- Second name -->
								<div class="mb-4">
									<label for="exampleInputSecondName" class="form-label">Second name *</label>
									<div class="input-group input-group-lg">
										<span class="input-group-text bg-light rounded-start border-0 text-secondary px-3"><i class="bi bi-layout-text-sidebar"></i></span>
										<input v-model="secondName" type="text" class="form-control border-0 bg-light rounded-end ps-1" placeholder="Second name" id="exampleInputSecondName">
									</div>
								</div>

								<!-- identificationNumber-->
								<div class="mb-4">
									<label for="exampleInputidentificationNumber" class="form-label">Identification number *</label>
									<div class="input-group input-group-lg">
										<span class="input-group-text bg-light rounded-start border-0 text-secondary px-3"><i class="bi bi-person-badge-fill"></i></span>
										<input v-model="identificationNumber" type="text" class="form-control border-0 bg-light rounded-end ps-1" placeholder="identification number" id="exampleInputidentificationNumber">
									</div>
								</div>

								<!-- Phone number -->
								<div class="mb-4">
									<label for="exampleInputPhoneNumber" class="form-label">Phone number *</label>
									<div class="input-group input-group-lg">
										<span class="input-group-text bg-light rounded-start border-0 text-secondary px-3"><i class="bi bi-phone-fill"></i></span>
										<input v-model="phonenumber" type="text" class="form-control border-0 bg-light rounded-end ps-1" placeholder="Phone number" id="exampleInputPhoneNumber">
									</div>
								</div>

								<!-- Email -->
								<div class="mb-4">
									<label for="exampleInputEmail1" class="form-label">Email address *</label>
									<div class="input-group input-group-lg">
										<span class="input-group-text bg-light rounded-start border-0 text-secondary px-3"><i class="bi bi-envelope-fill"></i></span>
										<input v-model="email" type="email" class="form-control border-0 bg-light rounded-end ps-1" placeholder="E-mail" id="exampleInputEmail1">
									</div>
								</div>
								<!-- Password -->
								<div class="mb-4">
									<label for="inputPassword5" class="form-label">Password *</label>
									<div class="input-group input-group-lg">
										<span class="input-group-text bg-light rounded-start border-0 text-secondary px-3"><i class="fas fa-lock"></i></span>
										<input v-model="password" type="password" class="form-control border-0 bg-light rounded-end ps-1" placeholder="*********" id="inputPassword5">
									</div>
								</div>


								<!-- Button -->
								<div class="align-items-center mt-0">
									<div class="d-grid">
										<button class="btn btn-primary mb-0" type="submit">Sign Up</button>
									</div>
								</div>
							</form>
							<!-- Form END -->



							<!-- Sign up link -->
							<div class="mt-4 text-center">
								<span>Already have an account?<nuxt-link to="sign-in"> Sign-in here</nuxt-link></span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</main>
</template>
<script>

export default {
  data() {
    return {
      firstName: '',
      secondName: '',
      identificationNumber: '',
      phonenumber: '',
      email: '',
      password: '',
      error: null,
    };
  },

  methods: {
    async register() {
      try {
        await this.$axios.post('auth/signup', {
          firstName: this.firstName,
          secondName: this.secondName,
          identificationNumber: this.identificationNumber,
          username: this.phonenumber,
          email: this.email,
          password: this.password,
        });

        await this.$auth.loginWith('local', {
          data: {
            username: this.phonenumber,
            password: this.password,
          },
        });

        this.$router.push('/');
      } catch (e) {
        this.error = e.response.data.message;
      }
    },
  },
};
</script>
