/**
 * Created by Alex on 2015-11-04.
 */

function readURL(idFileExplorer, idAvatarProfil) {
    var file = document.getElementById(idFileExplorer).files[0];
    var reader = new FileReader();
    reader.onloadend = function () {
        document.getElementById(idAvatarProfil).style.backgroundImage = "url(" + reader.result + ")";
    }
    if (file) {
        reader.readAsDataURL(file);
    } else {
    }
}
function checkImage(idFileExplorer, idAvatarProfil) {
    var x = document.getElementById(idFileExplorer); // get the file input element in your form
    var f = x.files.item(0); // get only the first file from the list of files
    var filesize = f.size;
    // Si l'image est plus petite que 10mb
    if (filesize < 10485760) {
        document.getElementById('errorDiv').innerHTML = '';
        readURL(idFileExplorer, idAvatarProfil);
    }
    else {
        document.getElementById('errorDiv').innerHTML = '<span style="color:red" id="image-error">Choisissez une image de moins de 10mb</span>';
    }
}
function TestFileType(idFileExplorer, idAvatarProfil) {
    var fileName = document.getElementById(idFileExplorer).value;
    var fileTypes = /(.jpg|.jpeg|.gif|.png)$/i;
    var extensionNames = ".jpg / .jpeg / .gif / .png";
    if (fileName != '') {
        if (fileTypes.test(fileName)) {
            document.getElementById('errorDiv').innerHTML = '';
            checkImage(idFileExplorer, idAvatarProfil); // Vérification de la taille de l'image

        }
        else {
            //document.getElementById('avatar').style.backgroundImage = "/uploaded-images/no_avatar.jpg";
            document.getElementById('errorDiv').innerHTML = '<span style="color:red" id="image-error">Doit être une image du type ' + extensionNames + ' </span>';
        }
    }
    else {
        //document.getElementById('avatar').style.backgroundImage = "/uploaded-images/no_avatar.jpg";
        document.getElementById('errorDiv').innerHTML = '<span style="color:red" id="image-error">Le nom d\'image est vide</span>';
    }
}

function formsubmit()
{
    $('#formUser').submit();
}
function deleteSubmit()
{
    $('#formDelete').submit();
}

function modalSubmitDelete(id)
{
    document.getElementById('idObjectDelete').value = id;
    $('#delete').submit();
}

function modalSubmitModifier(id)
{
    document.getElementById('idObjectModifier').value = id;
    $('#modifier').submit();
}