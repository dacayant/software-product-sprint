// How to use:
// Add the 'hide-' or 'show-' name to the trigger element, followed by the id of the target element

$(document).ready(
    // Detects when elements with 'show-' in their name and the 'trigger' class are clicked
    function(){
        $( "[name*='show-']" ).click(
            function(){
                // Takes the id number in the name of the trigger element
                var trigger_id = $(this).attr("name").replace("show-", "");
                // Shows the element with the corresponding id
                $("#"+trigger_id).show()
            }
        );

        $( "[name*='hide-']" ).click(
            function(){
                var trigger_id = $(this).attr("name").replace("hide-", "");
                $("#"+trigger_id).hide()
            }
        );
});