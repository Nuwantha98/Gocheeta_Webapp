class FormValidation{
 
    showErrorMsg(index,msg){
        const form_group = document.getElementsByClassName('form-group')[index]
        form_group.classList.add('error')
        form_group.getElementsByTagName('span')[0].textContent = msg   
    }
    showSuccessMsg(index){
        const form_group = document.getElementsByClassName('form-group')[index]
        form_group.classList.remove('error')
        form_group.classList.add('success')
    }
   

}
