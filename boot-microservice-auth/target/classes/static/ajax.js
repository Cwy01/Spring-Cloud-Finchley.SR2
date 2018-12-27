$ajax({
	url: 'localhost:8989/uaa/oauth/token',
	datatype:'json',
	type: 'post',
	headers: {'Authorization':'Basic c2VydmljZSloaToxMjMONTY='},
	async: false,
	data: {
		username: fzp,
		password: 123456,
		grant_type: 'password'
	},
	success: function(data){},
	error: function (){}
	
});