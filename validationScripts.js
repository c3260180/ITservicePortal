// Alessandro Pirillo
// c3260180

 function validateEmail()
{
	var checkEmail;
	checkEmail = document.getElementById("Email").value;

	if(checkEmail.includes("@") == false)
    {
    	document.getElementById("EmailError").innerHTML = "email doesnt contain @";
    	return false;
    }
    if(checkEmail.includes(" ") == true)
    {
        document.getElementById("EmailError").innerHTML = "Email can not contain spaces";
        return false;
    }
    else
    {
    	document.getElementById("EmailError").innerHTML = "";
    	return true;
    }

}

//wont accept IDs with numbers
function validateUserID()
{
	var checkID;
	checkID = document.getElementById("userID").value;
	for (var i = 0; i < 10; i++) 
	{
		if(checkID.search(i) != -1)
		{
			document.getElementById("UserIdError").innerHTML = "UserID should not contain numbers";
			return false;
		}

	}
    if(hasWhiteSpace(checkID))
    {
        document.getElementById("UserIdError").innerHTML = "UserID can not contain spaces";
        return false;
    }
			document.getElementById("UserIdError").innerHTML = "";
			return true;

}

function hasWhiteSpace(s) 
{
  return /\s/g.test(s);
}




function getTimeFormated()
{
    var d = new Date();
    dformat = [d.getDate(), d.getMonth()+1, d.getFullYear()].join('/')+' '+[ d.getSeconds(), d.getMinutes(), d.getHours()].join(':');
    document.getElementById("TimeOfBooking").value = dformat;
    console.log("sadsad");

}  
