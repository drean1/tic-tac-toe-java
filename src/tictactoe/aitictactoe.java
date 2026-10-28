/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author Lenovo
 */
public class aitictactoe {
    char langkahcomputer;
    public int hitungminimax(papantictactoe papan,int kedalaman,char putaran,char computer){
        char orang;
        if(computer == 'X'){
            orang= 'O';
            if (papan.X_menang())
                return 1;
            if (papan.O_menang())
                return -1;
        } else {
            orang = 'X';
            if(papan.X_menang())
                return -1;
            if(papan.O_menang())
                return 1;
        }
        if(papan.papanpenuh())
            return 0;
        
        if (putaran == computer && kedalaman==0){
            char petak = maximazeminimax(papan,computer);
            if(petak != '0'){
                langkahcomputer = petak;
                return -1;
            }
            petak = maximazeminimax(papan,orang);
            if (petak != '0'){
                langkahcomputer = petak;
                return -1;
            }
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        char [] petak_kosong = papan.ambilsemuapetak();
        int kosong = petak_kosong.length;
        for (int i =0; i<kosong; ++i){
            char petak = petak_kosong[i];
            if(putaran == computer){
                papan.tandaipapan(petak, computer);
                int score = hitungminimax(papan,kedalaman +1,orang,computer);
                max = Math.max(score, max);
                if(score >= 0){
                    if (kedalaman == 0)
                            langkahcomputer = petak;
                }else if (score == 1){
                    papan.resetpapan(petak);
                    break;
                    
                }
                if (i == papan.ambilsemuapetak().length - 1 && max > 0){
                    if (kedalaman == 0)
                            langkahcomputer = petak;
                }
            }else{
                papan.tandaipapan(petak, orang);
                int score = hitungminimax(papan,kedalaman +1,computer,computer);
                min = Math.min(score, min);
                if(min == -1){
                    papan.resetpapan(petak);
                    break;
                }
            }
            papan.resetpapan(petak);
        }
        if(putaran == computer)
            return max;
        else
            return min;
    }
    protected char maximazeminimax(papantictactoe papan,char pemain){
        char langkah = '0';
        int kosong = 0;
        int xpemain = 0;
        int dkosong = 0;
        int dpemain = 0;
        char dlangkah = '0';
        int dxkosong = 0;
        int dxpemain = 0;
        char dxlangkah = '0';
        
        for (int x=0; x<3; x++){
            xpemain =0;
            kosong = 0;
            langkah ='0';
            for(int y=0; y<3; y++){
                if(papan.papangame[x][y] == pemain)
                    xpemain++;
                else
                    if(papan.papangame[x][y] != 'X' && papan.papangame[x][y] != 'O'){
                        kosong++;
                        langkah = papan.papangame[x][y];
                    }
                if(x == y ){
                    if(papan.papangame[x][y] == pemain)
                        dpemain++;
                    else
                        if (papan.papangame[x][y] != 'X' && papan.papangame[x][y] != 'O'){
                            dkosong++;
                            dlangkah = papan.papangame[x][y];
                        }
                }
                if((x == 0 && y == 2) || (x == 1 && y == 1)|| (x == 2 && y == 0))
                {
                    if (papan.papangame[x][y] == pemain)
                        dxpemain++;
                    else
                        if (papan.papangame[x][y] != 'X' && papan.papangame[x][y] != 'O'){
                            dxkosong++;
                            dxlangkah = papan.papangame [x][y];
                        }
                }
            }
            if (xpemain == 2 && kosong == 1)
                return langkah;
            langkah = '0';
        }
        if(dpemain == 2 && dkosong == 1)
            return dxlangkah;
        if (dxpemain == 2 && dxkosong == 1)
            return dxlangkah;
        for (int y=0; y<3; y++){
            kosong=0;
            xpemain =0;
            for(int x=0; x<3; x++){
                if (papan.papangame[x][y] == pemain)
                    xpemain++;
                else
                    if(papan.papangame[x][y] != 'X'&& papan.papangame[x][y] != 'O'){
                        kosong++;
                        langkah = papan.papangame[x][y];
                    }
            }
            if (xpemain == 2 && kosong == 1)
                return langkah;
            langkah = '0';
        }
        return langkah;
    }
    public char Langkahcomputer(){
        return langkahcomputer;
    }
}

