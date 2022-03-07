<template>
		<div class="page-content-wrapper border">

			<!-- Title -->
			<div class="row mb-3">
				<div class="col-12">
					<h1 class="h3 mb-0">Loans History</h1>
				</div>
			</div>

			<!-- All review table START -->
			<div class="card bg-transparent border">


				<!-- Card body START -->
				<div class="card-body pb-0">
					<!-- Table START -->
					<div class="table-responsive-xxl border-0">
						<table class="table table-dark-gray align-middle p-4 mb-0 table-hover">
							<!-- Table head -->
							<thead>
								<tr>
									<th scope="col" class="border-0">First name</th>
									<th scope="col" class="border-0">Second name</th>
									<th scope="col" class="border-0">Identification number</th>
									<th scope="col" class="border-0">Phone number</th>
									<th scope="col" class="border-0">Disbursement Date</th>
									<th scope="col" class="border-0">Repayment Date</th>
									<th scope="col" class="border-0">Amount</th>
								</tr>
							</thead>

							<!-- Table body START -->
							<tbody>

								<!-- Table row -->

								<tr v-for="(loan, i) in user_loans" :key="i">

									<td>{{loan.firstName}}</td>
									<td>{{loan.secondName}}</td>
									<td>{{loan.identificationNumber}}</td>
									<td>{{loan.phoneNumber}}</td>
									<td>{{loan.disbursementDate}}</td>
									<td>{{loan.repaymentDate}}</td>
									<td>Ksh {{loan.amount}}</td>
								</tr>




							</tbody>
							<!-- Table body END -->
						</table>
					</div>
					<!-- Table END -->
				</div>
				<!-- Card body END -->

			</div>
			<!-- All review table END -->
		</div>
</template>

<script>
export default {
layout: 'custom',
data() {
  return {
    user_loans: [],
    user: this.$cookiz.get('user1') ? this.$cookiz.get('user1') : null
  }
},
mounted() {
this.allLoans()
},
methods: {
    async allLoans(){
      if (this.user) {

          this.loading = true;

      try {
        const ln = new FormData()
                ln.append('userId', this.user.id)

        this.user_loans = await this.$axios.get(`/all/customers/loans`, ln).then(res => res.data)

      } catch (error) {
        console.log('error', error)
      }
          this.loading = false;
      }
    },
}
}
</script>
