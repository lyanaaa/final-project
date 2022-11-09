import java.util.*;
import java.io.*;
import javax.swing.*;

public class MainCitizen 
{
    public static void main(String [] args) {
        
    try {
            //create the reader
            BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\User\\eclipse-workspace\\FINAL PROJECT SWC3344\\src\\listciti.txt"));
            //create the object array
            LinkedList <Citizen> citizenList = new LinkedList<>();
            LinkedList <Citizen> completedList = new LinkedList<>();
            //declare the object name
            Citizen c;
            String indata = null;
            //reading data
            while((indata = in.readLine())!= null) {


            StringTokenizer st = new StringTokenizer(indata, ";");
            String name= st.nextToken();
            String ic = st.nextToken();
            String state = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            String Category = st.nextToken();
            String firstdose = st.nextToken();
            String seconddose = st.nextToken();
            String certificate= st.nextToken();
            

            //creating object 
            c = new Citizen(name, ic, state, age, Category, firstdose, seconddose, certificate);

            //store the object in parcelsList
            citizenList.add(c);
            }
            in.close(); //close the reader

        Stack<Citizen> stCenter1 = new Stack<>();
        Stack<Citizen> stCenter2 = new Stack<>();
        Stack<Citizen> stCenter3 = new Stack<>();

        Queue<Citizen> qCenter1 = new LinkedList<>();
        Queue<Citizen> qCenter2 = new LinkedList<>();
        Queue<Citizen> qCenter3 = new LinkedList<>();


        int menu = 0;
        do {
            //instruction
            menu = Integer.parseInt(JOptionPane.showInputDialog("Choose the menu \n Menu 1 - Add new recipient \n Menu 2 - Remove existing recipient \n Menu 3 - Update first dose status \n Menu 4 - update second dose status \n Enter 5 - display \n Menu6 - exit"));

            if(menu == 1) //add the new recipient
            {
                //ask user to enter new data for new a object
                String name = JOptionPane.showInputDialog("Enter recipient name");
                String ic = JOptionPane.showInputDialog("Enter recipient ic number");
                String state = JOptionPane.showInputDialog("Enter recipient State");
                int age = Integer.parseInt(JOptionPane.showInputDialog("Enter recipient age"));
                String Category = JOptionPane.showInputDialog("Enter category");
                String firstdose = "null";
                String seconddose = "null";
                String certicate = "null";
                
                 //create the object
                 c = new Citizen(name, ic, state, age, Category, firstdose, seconddose, certicate);
                 
                 //add the object into citizen
                 citizenList.add(c);

                }
                else if(menu == 2) //remove citizen list
                {

                    // enter name
                    String ic = JOptionPane.showInputDialog("Enter ic to remove existing recipient");
                    for(int i = 0; i<citizenList.size(); i++) {
                       
                        c = citizenList.get(i); //retrieve the object
                        if(c.getIc().equalsIgnoreCase(ic)) {

                            citizenList.remove(c); //remove the object
                        }
                    }

                }

            else if(menu == 3) { 
                
                while(!citizenList.isEmpty()) {
                    c = citizenList.removeLast();
                    if (c.getAge() >= 18 && c.getAge()<=30) {
                        stCenter1.push(c); 
                    }
                    
                    if (c.getAge() >= 31 && c.getAge()<=49) {
                    stCenter2.push(c); 
                    }
                    if (c.getAge() >= 50) {
                    stCenter3.push(c); 
                    }
                }

                while(!stCenter1.isEmpty() )
                {
                    c = stCenter1.pop();
                    if(c.getFirstdose().equalsIgnoreCase("null"))
                    {
                        c.setFirstdose("Completed");
                        qCenter1.add(c);
                    }
                }

                while(!stCenter2.isEmpty() )
                {
                    c = stCenter2.pop();
                    if(c.getFirstdose().equalsIgnoreCase("null"))
                    {
                        c.setFirstdose("Completed");
                        qCenter2.add(c);

                    }
                }

                while(!stCenter3.isEmpty() )
                {
                    c = stCenter3.pop();
                    if(c.getFirstdose().equalsIgnoreCase("null"))
                    {
                        c.setFirstdose("Completed");
                        qCenter3.add(c);

                    }
                }
            }
            else if(menu == 4){
                while(!qCenter1.isEmpty()){
                    c = qCenter1.remove();
                    c.setSeconddose("COMPLETED");
                    c.setCertificate("COMPLETED");
                    completedList.add(c);
                }
                
                while(!qCenter2.isEmpty()){
                    c = qCenter2.remove();
                    c.setSeconddose("COMPLETED");
                    c.setCertificate("COMPLETED");
                    completedList.add(c);
                }
        
                
                while(!qCenter3.isEmpty()){
                    c = qCenter3.remove();
                    c.setSeconddose("COMPLETED");
                    c.setCertificate("COMPLETED");
                    completedList.add(c);
                }
            }

            else if(menu == 5)
            {
            
                int submenu = 0;
                do
                {
                    submenu = Integer. parseInt(JOptionPane.showInputDialog("please Choose the following" +
                                                                        "\n Menu 1 - Display First Dose Recipient"+
                                                                        "\n Menu 2 - Display second Dose Recipient"));
                    if(submenu == 1)
                    {
                        String.format("| %15s | %15s | %15s | %15s | %15s | %15s | %15s | %15s |\n ", "name", "ic", "state", "age", "category", "firstdose", "seconddose", "certificate");
                        System.out.println(qCenter1.toString());
                        String.format("| %15s | %15s | %15s | %15s | %15s | %15s | %15s | %15s |\n ", "name", "ic", "state", "age", "category", "firstdose", "seconddose", "certificate");
                        System.out.println(qCenter2.toString());
                        String.format("| %15s | %15s | %15s | %15s | %15s | %15s | %15s | %15s |\n ", "name", "ic", "state", "age", "category", "firstdose", "seconddose", "certificate");
                        
                        System.out.println(qCenter3.toString());
                        
                    }
                    
                    if(submenu == 2 )
                    {
                        System.out.println(completedList.toString());
                    }
                }while(submenu != 3);

            }

        }while (menu != 6);

    }
        catch(FileNotFoundException fnf) {
            System.out.println("File not found");
        }
        catch(EOFException eof) {
            System.out.println("End of file error");
        }
        catch(IOException io) {
            System.out.println("wrong input!!!");
        }
        catch(NullPointerException npe) {
            System.out.println("null string");
        }
        catch(NumberFormatException nfe) {
            System.out.println("wrong input!!!");
        }
        finally {
            System.out.println("\nSystem end here.Bye!");
        }


    }
}
