    //검증식
    //영문과 숫자만 사용가능
    $.validator.addMethod("alphanumeric" , function(value, element) {
       return this.option(element) || /^[a-zA-Z0-9]+$/.test(value);
    });   
       
