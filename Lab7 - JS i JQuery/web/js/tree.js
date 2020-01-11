$(function() {

    alert("Działam - JavaScript :)");

    $.ajax({url:"data.json", dataType:"json"}).done(function(x){                 // wczytuje zawartość pliku json
		
		var tree = $.map(x, change)                                              // label -> text i nested -> children
		
		$("#tree").jstree({                                                      // wyświetlanie drzewa
			'core': 
			{
				'data': tree
			} ,
			'types': 
			{
				'file': 
				{
					'icon': 'jstree-file'
				} ,
				'dir': 
				{
					'icon': 'jstree-folder'
				}
			},
			'plugins': ['types']
		}) ;
	});


	$("#tree").on("changed.jstree", function(e,tree){                            // wyświetlanie opisu     
		$("#description").text(tree.node.original.description);
	});

});


function change(x){

	x.text = x.label;
	
	if('nested' in x){
		x.children = $.map(x.nested, change);
	}
	
	return x;
}




