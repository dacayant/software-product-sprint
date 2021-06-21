

$(document).ready(
    function(){
        $( ".trigger[name*='show-']" ).click(
            function(){
                var trigger_id = $(this).attr("name").replace("show-", "");
                $(".target[name*='" + trigger_id + "']").show()
            }
        );

        $( ".trigger[name*='hide-']" ).click(
            function(){
                var trigger_id = $(this).attr("name").replace("hide-", "");
                $(".target[name*='" + trigger_id + "']").hide()
            }
        );
});

// Search for elements start with id show-1
// Will match items with both show-1
// #show-1.trigger when clicked will .show()  #show-1.target