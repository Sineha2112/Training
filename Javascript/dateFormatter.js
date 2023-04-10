function dateFormatter(row, cell, value, columnDef, dataContext) {
	const date = new Date(value);
	var getDay = date.toLocaleString("default", { day: "2-digit" });
	var getMonth = date.toLocaleString("default", { month: "2-digit" });
	var getYear = date.toLocaleString("default", { year: "numeric" }); // Set the desired date format
 	return getDay + "-" + getMonth + "-" + getYear;// Format the date as a string
	  // Return the formatted date string
}
