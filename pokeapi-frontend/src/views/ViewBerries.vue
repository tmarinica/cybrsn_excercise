<template>
	<div>
		<h2 style="text-align:left; margin-bottom:30px;">Get berries sorted by field</h2>

		<b-form inline style="margin-bottom:20px;" @submit.prevent="getBerries">
			<label style="margin-right:10px;" for="inline-form-input-name">Sort by:</label>
			<b-input id="inline-form-input-name" class="mb-2 mr-sm-2 mb-sm-0" placeholder="For example: name" v-model="sortField" />

			<b-form-select id="inline-form-custom-select-pref" class="mb-2 mr-sm-2 mb-sm-0" :options="['ASC', 'DESC']" v-model="sortOrder" />

			<b-button variant="primary" @click="getBerries">Get</b-button>
		</b-form>

		<div style="overflow: auto; ">
			<b-alert variant="danger" :show="errorMessage != null && !isLoading" style="text-align:left;">{{ errorMessage }}</b-alert>
			<div class="spinner-border" style="float:left;" v-if="isLoading">
				<span class="sr-only">Loading...</span>
			</div>
		</div>

		<div v-for="berries in groupedBerries" :key="berries.id" class="row" style="margin-bottom:20px;">
			<div v-for="berry in berries" :key="berry.id" class="col-lg-4">
				<b-card :title="berry.name" :sub-title="'Id: ' + berry.id.toString()">
					<b-list-group style="text-align:left; font-style:italic; ">
						<b-list-group-item>growth_time: {{ berry.growth_time }}</b-list-group-item>
						<b-list-group-item>size: {{ berry.size }}</b-list-group-item>
						<b-list-group-item>natural_gift_power: {{ berry.natural_gift_power }}</b-list-group-item>
						<b-list-group-item>smoothness: {{ berry.smoothness }}</b-list-group-item>
						<b-list-group-item>soil_dryness: {{ berry.soil_dryness }}</b-list-group-item>
					</b-list-group>
				</b-card>
			</div>
		</div>
	</div>
</template>

<script>
import BerryService from "../services/berry.service"
import _ from "lodash"

export default {
	name: "ViewBerries",

	computed: {
		groupedBerries() {
			return _.chunk(this.berries, 3)
		},
	},

	data() {
		return {
			sortOrder: "ASC",
			sortField: null,
			berries: [],
			errorMessage: null,
			isLoading: false,
		}
	},

	methods: {
		getBerries() {
			if (!this.sortField) {
				this.errorMessage = "Sort field is empty!"
				return
			}

			this.isLoading = true
			this.berries = null
			BerryService.getSortedBerries(this.sortField, this.sortOrder).then(
				(res) => {
					this.berries = res.data
					this.errorMessage = null
					this.isLoading = false
				},
				(err) => {
					this.berries = null
					this.errorMessage = err.response.data
					this.isLoading = false
				}
			)
		},
	},
}
</script>

<style></style>
