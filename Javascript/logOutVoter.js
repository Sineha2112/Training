function logOutVoter() {
	if (confirm("Are you sure you want to Log out?") === true) {
		window.href("/Logout");
	}
	else {
		window.open("/userVoteHomePage")
	}
}
