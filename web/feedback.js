/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

                 function feedback1() {
                     
                       var dropcost1 = document.getElementById('costfeedbackweight'); 
                        var droptime1 = document.getElementById('timefeedbackweight');
                        var dropnod1 = document.getElementById('nodfeedbackweight');
                        var cost1 = dropcost1.options[dropcost1.selectedIndex].value;
                      
                        var time1 = droptime1.options[droptime1.selectedIndex].value;
                        
                        var nod1 = dropnod1.options[dropnod1.selectedIndex].value; 
                        
                         var sum1 =  parseInt(cost1)+parseInt(time1)+parseInt(nod1);

                         
                            if(sum1 == 100 && cost1!=0 && nod1!=0 && time1!=0) {
                                document.getElementById('costfeedbackweight').style.borderColor="green";
                                document.getElementById('timefeedbackweight').style.borderColor="green";
                                document.getElementById('nodfeedbackweight').style.borderColor="green";
                            }
                            else if (sum1 != 100 && cost1!=0 && nod1!=0 && time1!=0){
                                alert("Total weight % must be exactly 100");
                                document.getElementById('costfeedbackweight').style.borderColor="red";
                                document.getElementById('timefeedbackweight').style.borderColor="red";
                                document.getElementById('nodfeedbackweight').style.borderColor="red";
                            }
                            else
                            return 0;
                    }
                    function feedbackvalue() {
                        if (parseInt(document.getElementById('costfeedback').value)>100 || parseInt(document.getElementById('costfeedback').value)<0) {
                            document.getElementById('costfeedback').style.borderColor="red";
                            alert("Please enter value between 0 and 100");
                        }
                        else if(parseInt(document.getElementById('costfeedback').value)<100 && parseInt(document.getElementById('costfeedback').value)>0) 
                            document.getElementById('costfeedback').style.borderColor="green";
                        
                        if (parseInt(document.getElementById('timefeedback').value)>100 || parseInt(document.getElementById('timefeedback').value)<0) {
                            document.getElementById('timefeedback').style.borderColor="red";
                            alert("Please enter value between 0 and 100");
                        }
                        else if(parseInt(document.getElementById('timefeedback').value)<100 && parseInt(document.getElementById('timefeedback').value)>0) 
                            document.getElementById('timefeedback').style.borderColor="green";
                        
                        if (parseInt(document.getElementById('nodfeedback').value)> 100 || parseInt(document.getElementById('nodfeedback').value)<0) {
                            document.getElementById('nodfeedback').style.borderColor="red";
                            alert("Please enter value between 0 and 100");
                        }
                        else if(parseInt(document.getElementById('nodfeedback').value)<100 && parseInt(document.getElementById('nodfeedback').value)>0)
                            document.getElementById('nodfeedback').style.borderColor="green";                        
                    }
                 