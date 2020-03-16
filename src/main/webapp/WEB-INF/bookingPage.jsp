<!DOCTYPE html>
<html>
<body bgcolor="black" text="red">
<form    action="process"       method="post">
      <table>
          <tr>
              <td>FirstName : </td>
              <td><input   type="text"    name="firstName"> </td>
          </tr>
          <tr>
              <td>LastName : </td>
              <td><input   type="text"    name="lastName"> </td>
          </tr>
          <tr> 
               <td>Email : </td> 
               <td> <input   type="text"    name="email"> </td>
          </tr>

          <tr>  
               <td> SeatNo : </td>
               <td> <input   type="text"    name="seatNo"> </td>
          </tr>
          <tr>
               <td> Mobile : </td>
               <td> <input   type="text"    name="mobile"> </td>
          </tr>
          <tr>
               <td> Age : </td>
               <td> <input   type="text"    name="age"> </td>
          </tr>
          

          <tr>
               <td> Gender : </td> 
               <td><input type="radio" name="gender" value="MALE"> Male
               <input type="radio" name="gender" value="FEMALE"> Female 
               <input type="radio" name="gender" value="OTHERS"> Others</td>
          </tr>

          <tr>
               <td>Date of Journey(yyyy.MM.dd): </td>
               </td>  <td> <input   type="text"    name="dateOfJourney"> </td>
          </tr>
          
          <tr>
               <td> Source : </td>
               <td> <input   type="text"    name="source"> </td>
          </tr>
          
          <tr>
               <td> Destination : </td>
               <td> <input   type="text"    name="destination"> </td>
          </tr>
          
          

          <tr>
               <td  colspan="5">   <input   type="submit"    value="submit"> </td>
          </tr>
      </table>
</form>  
</body>
</html>