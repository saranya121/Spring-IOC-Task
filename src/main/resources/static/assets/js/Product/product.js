function switchPage(value) {
	if (value == 'Add') {
		window.location.href = "/product/add";
	} else if (value == 'Back') {
		window.location.href = "/product/index";
	} else if (value == 'Display') {
		window.location.href = "/product/displayAll";
	}

}