public class Ciclica{
    String datos; //100100
    String agregado; //CRC
    String cadena;
    String divisor; // 1101
    String resulParcial = "";
    String cociente = "";
    static String crc = "";
    String tabulador = "";
    String tabulador2 = " ";

    public Ciclica(String datos, String divisor, String crc){
        agregado = crc;
        this.datos = datos;
        this.divisor = divisor;
        cadena = datos + crc;
    }//constructor

    public void imprime(){
        System.out.println("datos "+datos);
        System.out.println("agregado "+agregado);
        System.out.println("               ----------");
        System.out.println("binario    "+divisor+"|"+cadena+"\n");
        //InterfazCiclica.jTextArea1.append("datos "+datos+"\n");
        //InterfazCiclica.jTextArea1.append("agregado "+agregado+"\n");
        //InterfazCiclica.jTextArea1.append("               \t  -----------------\n");
        //InterfazCiclica.jTextArea1.append("binario    "+divisor+"|"+cadena+"\n\n");
    }
    
    public String getCrc(){
        return crc;
    }
       
    public String getBinario(){
        return cadena;
    }

    public void recorrer(int li, int ls){
        tabulador += " ";
        tabulador2 +=" ";
        
        if(ls == cadena.length()+1){
            System.out.println("cociente total "+cociente);
            //InterfazCiclica.jTextArea1.append("cociente total "+cociente+"\n");
            crc = resulParcial;
            System.out.println("Residuo  "+crc+"\n");
            //InterfazCiclica.jTextArea1.append("Residuo  "+crc+"\n");
            return;
        }

        if(li == 0){
            System.out.println("parte a dividir "+cadena.substring(li, ls));
            //InterfazCiclica.jTextArea1.append("pte a dividir  "+cadena.substring(li, ls)+"\n");
            
            if(resulParcial.startsWith("0")){
            System.out.println("divisor        "+tabulador+"0000");
            //InterfazCiclica.jTextArea1.append("divisor            "+tabulador+"0000"+"\n");
            }
            else{
            System.out.println("divisor        "+tabulador+""+divisor);
            //InterfazCiclica.jTextArea1.append("divisor            "+tabulador+""+divisor+"\n");
           }
            System.out.println("               -------");
            //InterfazCiclica.jTextArea1.append("                     -------"+"\n");
            resulParcial =  resta(cadena.substring(li, ls), divisor);
            System.out.println("                 "+resulParcial);
            //InterfazCiclica.jTextArea1.append("                    "+resulParcial+"\n\n");
            System.out.println("ccite parcial "+cociente+"\n");
            //InterfazCiclica.jTextArea1.append("ccite parcial "+cociente+"\n\n");
            recorrer(li+1, ls+1);
            return;
        }
        
        //AGREGAR AL ANTERIOR COCIENTE EL SIGUIENTE NUMERO PARA DIVIDIR 4 BITS
        resulParcial += cadena.charAt(ls-1);
        System.out.println("parte a dividir"+tabulador+""+resulParcial);
        //InterfazCiclica.jTextArea1.append("pte a dividir"+tabulador+""+resulParcial+"\n");
        
        if(resulParcial.startsWith("0")){
            System.out.println("divisor        "+tabulador+"0000");
            //InterfazCiclica.jTextArea1.append("divisor          "+tabulador+"0000"+"\n");
        }
        else{
            System.out.println("divisor        "+tabulador+""+divisor);
            //InterfazCiclica.jTextArea1.append("divisor          "+tabulador+""+divisor+"\n");
        }
        
        
        System.out.println("              "+tabulador+"-------");        
        //InterfazCiclica.jTextArea1.append("                   "+tabulador+"-------"+"\n");
        resulParcial = resta(resulParcial, divisor);
        System.out.println("               "+tabulador2+""+resulParcial);
        //InterfazCiclica.jTextArea1.append("                "+tabulador2+""+resulParcial+"\n\n");
        System.out.println("ccite parcial "+cociente+"\n");
        //InterfazCiclica.jTextArea1.append("ccite parcial "+cociente+"\n\n");
        recorrer(li + 1, ls + 1);
        return;
    }
    
    public String resta(String div, String divisor){
        String resultado = "";
        String divisorNeutro = "0000";
        
        if(div.startsWith("0")){
            for(int i = 1; i < 4; i++){
            if(div.charAt(i) == divisorNeutro.charAt(i))
                resultado += "0";
            else
                resultado += "1";
            }
            cociente += "0";
        }
        else{
        for(int i = 1; i < 4; i++){
            if(div.charAt(i) == divisor.charAt(i))
                resultado += "0";
            else
                resultado += "1";
            }
            cociente += "1";
        }
        return resultado;
    }


}//end class