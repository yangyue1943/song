/*
���ݣ�jQuery-Extend
���ߣ����ɻ�
ʱ�䣺{createDate}
*/
(function($) {
	jQuery.fn.extend({
		myExtend:function(opts){
			var that=this;
			this.opts=$.extend({
				
			},opts || {});
		}
	});
})(jQuery)