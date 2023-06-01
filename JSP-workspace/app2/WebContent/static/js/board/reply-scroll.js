$("#more-replies").hide();


const $replyWrite = $("#reply-write-wrap");
const $writeButton = $("#reply-write-wrap button");
const $replyUpdate = $(".reply-update-wrap");
const $updateButton = $("span.update");
const $cancelButton = $("button.calcel");
const $writeTextarea = $("form[name='writeForm'] textarea");
const replyTexts = ['취소', ' ', '댓글 달기'];
const $ul = $("#replies-wrap ul");
const $dimmed = $("div.logo-area");

/*=======================================================================*/
/*퍼블리싱*/
/*=======================================================================*/
let flag = 1;

function showReply(){
    $replyWrite.slideToggle(function(){
        flag *= -1;
        $("#show-reply a").text(replyTexts[flag + 1]);
    });
}

$writeButton.on("mouseover", function(){
    $(this).css("background-color", "#F3F5F7");
});

$writeButton.on("mouseout", function(){
    $(this).css("background-color", "rgb(255 255 255)");
});

$updateButton.on("click", function(){
    let content = $replyUpdate.prev().text().trim();
    let $textarea = $replyUpdate.find("textarea");
    $textarea.val(content);
    $replyUpdate.prev().hide();
    $replyUpdate.next().hide();
    $replyUpdate.show();
});

$cancelButton.on("click", function(){
    $replyUpdate.hide();
    $replyUpdate.prev().show();
    $replyUpdate.next().show();
});

$writeTextarea.on("focus", function(){
    $(this).closest("span").css('border', '1px solid rgb(235 124 120)');
});

$writeTextarea.on("blur", function(){
    $(this).closest("span").css('border', '1px solid rgba(0, 0, 0, 0.1)');
});














