function candidateGrid() {
	var dataView;
	var grid;

	var data = document.getElementById("candidate").value
	console.log(data);
	var data1 = JSON.parse(data);
	var candidateList = [];
	for (var i = 0; i < data1.length; i++) {
		candidateList.push(data1[i]['CandidateCode']);
		console.log(data1[i]['CandidateCode']);
	}
	console.log(candidateList);
	var nextId = 1;
	data1.forEach(function(item) {
		// Generate a unique id using the nextId value
		var itemId = "item_" + nextId;
		// Set the id property of the item object
		item.id = itemId;
		// Increment the nextId value
		nextId++;
	});
	// Use the updated items array list with unique ids
	/* unique id end */
	var options = {
		enableCellNavigation: true,
		showHeaderRow: true,
		headerRowHeight: 30,
		explicitInitialization: true
	};
	var columnFilters = {};
	function checkboxFormatter(row, cell, value, columnDef, dataContext) {
		let a = dataContext.CandidateCode;
		return '<input type="checkbox" value="' + a + '" name="checkName" id="checkBox"' + (value ? 'checked="checked"' : '') + '/>';
	}

	//var check= document.getElementById("checkBox");
	var check = document.querySelectorAll('input[type="checkbox"]:checked');
	console.log(check);
	var columns = [{
		id: "select",
		name: "Select",
		field: "select",
		formatter: checkboxFormatter,
		width: 30
	}, {
		id: "ElectionCode",
		name: "Election Code",
		field: "ElectionCode",
		width: 70,
		sortable: true

	}, {
		id: "CandidateCode",
		name: "Candidate Code ",
		field: "CandidateCode",
		sortable: true,
		width: 80,
	}, {
		id: "PartyName",
		name: "Party Name ",
		field: "PartyName",
		sortable: true,
		width: 110
	}, {
		id: "Name",
		name: "Candidate Name",
		field: "Name",
		sortable: true,
		width: 160
	}, {
		id: "CandidateGender",
		name: " Gender ",
		field: "CandidateGender",
		sortable: true,
		width: 80
	}, {
		id: "age",
		name: " Age",
		field: "age",
		width: 40,
		sortable: true,
	}, {
		id: "Address",
		name: "Address",
		field: "Address",
		width: 180,

	}, {
		id: "city",
		name: "City",
		field: "city",
		width: 120,

	}, {
		id: "Nationality",
		name: "Nationality",
		field: "Nationality",
		width: 70,

	}, {
		id: "MobileNumber",
		name: "Mobile Number",
		field: "MobileNumber",
		width: 120,

	}, {
		id: "CandidateEmailId",
		name: "Email Id ",
		field: "CandidateEmailId",
		width: 180,

	}];
	/* filter start */
	$(function() {
		function filter(item) {
			for (var columnId in columnFilters) {
				if (columnId !== undefined
					&& columnFilters[columnId] !== "") {
					var c = grid.getColumns()[grid.getColumnIndex(columnId)];
					if (item[c.field] !== columnFilters[columnId]) {
						return false;
					}
				}
			}
			return true;
		}
		/* filter end */
		dataView = new Slick.Data.DataView();
		grid = new Slick.Grid("#myGrid", dataView, columns, options);
		/* filter start */
		dataView.onRowCountChanged.subscribe(function(e, args) {
			grid.updateRowCount();
			grid.render();
		});
		dataView.onRowsChanged.subscribe(function(e, args) {
			grid.invalidateRows(args.rows);
			grid.render();
		});
		$(grid.getHeaderRow()).delegate(":input", "change keyup",
			function(e) {
				var columnId = $(this).data("columnId");
				if (columnId != null) {
					columnFilters[columnId] = $.trim($(this).val());
					dataView.refresh();
				}
			});
		grid.onHeaderRowCellRendered.subscribe(function(e, args) {
			$(args.node).empty();
			$("<input type='text'>").data("columnId", args.column.id).val(
				columnFilters[args.column.id]).appendTo(args.node);
		});
		grid.init();
		dataView.beginUpdate();
		dataView.setItems(data1);
		dataView.setFilter(filter);
		dataView.endUpdate();
	})
}
