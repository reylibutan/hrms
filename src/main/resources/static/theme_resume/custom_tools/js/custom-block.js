	//add block
	jQuery('.switherHead').append('<div id="swither_block"><a href="#" id="theme_switcher"><span class="switch_icon icon-cog"></span><span class="switch_wrap">Light version</span></a></div>');
	jQuery('#swither_block').fadeIn(1000);


	jQuery('body').append('<!-- custom block --><div id="opt_block">  <div class="opt_header"> <span></span> </div>  <div class="opt_row bg_color">    <h3>background color:</h3>    <div id="bg_col" class="colorSelector"></div>  </div>  <div class="opt_row bg_pat">    <h3>Background Pattern:</h3>    <ul class="patterns_select setBackground">      <li><a href="#" data-custom="pattern1"><img src="theme_resume/images/bg/pattern1.png" alt=""></a></li>      <li><a href="#" data-custom="pattern2"><img src="theme_resume/images/bg/pattern2.png" alt=""></a></li>      <li><a href="#" data-custom="pattern3"><img src="theme_resume/images/bg/pattern3.jpg" alt=""></a></li>      <li><a href="#" data-custom="pattern4"><img src="theme_resume/images/bg/pattern4.png" alt=""></a></li>      <li><a href="#" data-custom="pattern5"><img src="theme_resume/images/bg/pattern5.png" alt=""></a></li>    </ul>  </div>  <div class="opt_row bg_img">    <h3>Background Image:</h3>    <ul class="bg_select setBackground">      <li><a href="#" data-custom="bg1"><img src="theme_resume/images/bg/bg1.jpg" alt=""></a></li>      <li><a href="#" data-custom="bg2"><img src="theme_resume/images/bg/bg2.jpg" alt=""></a></li>      <li><a href="#" data-custom="bg3"><img src="theme_resume/images/bg/bg3.jpg" alt=""></a></li>    </ul>  </div></div><!-- /custom block -->');
	jQuery('#opt_block').fadeIn(1000);


jQuery(window).ready(function() {
    
	
		//set cookie
		jQuery('#opt_block .opt_header span').click(function(){
			if(jQuery(this).hasClass('vis')) {
				jQuery(this).removeClass('vis').parents('#opt_block').animate({'marginRight':0}, 700, 'easeInCubic');
			}
			else{
				jQuery(this).addClass('vis').parents('#opt_block').animate({'marginRight':222}, 700, 'easeInCubic');
			}
		});
		jQuery('.patterns_select li a').click(function(){
			jQuery('body').removeClass('pattern1 pattern2 pattern3 pattern4 pattern5 bg1 bg2 bg3');
			var src = jQuery(this).attr('data-custom');
			jQuery('body').removeAttr("style").addClass(src)
			setCookie('body_img', src, 9999999, '/');
			deleteCookie('body_bg', '/');
			return false;
		});
		jQuery('.bg_select li a').click(function(){
			jQuery('body').removeClass('pattern1 pattern2 pattern3 pattern4 pattern5 bg1 bg2 bg3');
			var src = jQuery(this).attr('data-custom');
			jQuery('body').removeAttr("style").addClass(src);
			setCookie('body_img', src, 9999999, '/');
			deleteCookie('body_bg', '/');
			return false;
		});
	
	
        jQuery.reject({
			reject : {
				all: false, // Nothing blocked
				msie5: true, msie6: true, msie7: true // Covers MSIE 5-7
			},
            imagePath: 'http://shiftcv.wpspace.net/wp-content/themes/cv/js/jreject/images/',
            header: 'Your browser is out of date', // Header Text
            paragraph1: 'You are currently using an unsupported browser', // Paragraph 1
            paragraph2: 'Please install one of the many optional browsers below to proceed',
            closeMessage: 'Close this window at your own demise!' // Message below close window link
        });
        empt = 'Name field can not be empty';
        to_lng = 'Too long name field';
        to_lng = 'Too long name field';
        empt_mail = 'Too short (or empty) email address';
        to_lng_mail = 'Too long email address';
        incor = 'Incorrect email address';
        mes_empt = 'message can not be empty';
        to_lng_mes = 'Too long message';
        
		setColorPicker('bg_col');
		
		
	function setColorPicker(id) {
	
		jQuery('#'+id).ColorPicker({
			color: jQuery('#'+id).val(),
			onShow: function (colpkr) {
				jQuery(colpkr).fadeIn(500);
				return false;
			},
			onHide: function (colpkr) {
				jQuery(colpkr).fadeOut(500);
				return false;
			},
			onChange: function (hsb, hex, rgb) {
				jQuery('body').css('background', '#' + hex);
				jQuery('#'+id).css('backgroundColor', '#' + hex);
				setCookie('body_bg', '#'+hex, 9999999, '/');
				deleteCookie('body_img', '/');
				deleteCookie('body_pt', '/');
			}
		});
	}


	function setColorPicker(id) {
	
		jQuery('#'+id).ColorPicker({
			color: jQuery('#'+id).val(),
			onShow: function (colpkr) {
				jQuery(colpkr).fadeIn(500);
				return false;
			},
			onHide: function (colpkr) {
				jQuery(colpkr).fadeOut(500);
				return false;
			},
			onChange: function (hsb, hex, rgb) {
				jQuery('body').css('background', '#' + hex);
				jQuery('#'+id).css('backgroundColor', '#' + hex);
				setCookie('body_bg', '#'+hex, 9999999, '/');
				deleteCookie('body_img', '/');
				deleteCookie('body_pt', '/');
			}
		});
	}

	
	
});