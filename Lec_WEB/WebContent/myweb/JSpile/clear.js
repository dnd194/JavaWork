$(document).ready(function () {
    $('#find').focus(function () { 
        $('#find').attr('placeholder', "");
    });
    $('#find').blur(function(){
        $('#find').attr('placeholder',"sneakers, brands, news, price....")
    });
});