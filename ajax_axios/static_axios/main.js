// ./app.js

const vm = new Vue({
    el: '#app',
    data: {
        results: []
    },
    mounted() {
        axios.get("/item/")
        .then(response => {
			console.log(response);
            this.results = response.data})
    }
});