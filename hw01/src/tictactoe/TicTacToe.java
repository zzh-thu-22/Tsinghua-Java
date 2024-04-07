package tictactoe;

public class TicTacToe{
        int[] a={0,0,0};
        int[] A={0,0,0};        
        int[] b={0,0,0};
        int[] B={0,0,0};
        int[] c={0,0,0};
        int[] C={0,0,0};
    public TicTacToe()
    {

    }

    public int place(int player, int row, int column)
    {
        if(row==0)
        {
            if(a[column]==1)
            {
                return 3;
            }else{
                a[column]=1;
                if(player==1)
                {
                    A[column]=1;
                    if(column==0)
                    {
                        if(A[1]==1 && A[2]==1)
                        {
                            return 1;
                        }else if(B[0]==1&&B[1]==1)
                        {
                            return 1;
                        }else if(B[1]==1 && C[2]==1)
                        {
                            return 1;
                        }
                    }
                    if(column==1)
                    {
                        if(A[0]==1 && A[2]==1)
                        {
                            return 1;
                        }else if(B[1]==1&&C[1]==1)
                        {
                            return 1;
                        }
                    }
                    if(column==2)
                    {
                        if(A[0]==1 && A[1]==1)
                        {
                            return 1;
                        }else if(B[2]==1&&C[2]==1)
                        {
                            return 1;
                        }else if(B[1]==1 && C[0]==1)
                        {
                            return 1;
                        }
                    }
                }else{
                    A[column]=2;
                    if(column==0)
                    {
                        if(A[1]==2 && A[2]==2)
                        {
                            return 2;
                        }else if(B[0]==2&&B[1]==2)
                        {
                            return 2;
                        }else if(B[1]==2 && C[2]==2)
                        {
                            return 2;
                        }
                    }
                    if (column==1)
                    {
                        if(A[0]==2 && A[2]==2)
                        {
                            return 2;
                        }else if(B[1]==2&&C[1]==2)
                        {
                            return 2;
                        }
                    }
                    if(column ==2)
                    {
                        if(A[0]==2 && A[1]==2)
                        {
                            return 2;
                        }else if(B[2]==2&&C[2]==2)
                        {
                            return 2;
                        }else if(B[1]==2 && C[0]==2)
                        {
                            return 2;
                        }
                    }
                }
            }
        }else if(row==1)
        {
            if(b[column]==1)
            {
                return 3;
            }else{
                b[column]=1;
                if(player==1)
                {
                    B[column]=1;
                    if(column==0)
                    {
                        if(B[1]==1 && B[2]==1)
                        {
                            return 1;
                        }else if(A[0]==1 && C[0]==1)
                        {
                            return 1;
                        }
                    }
                    if(column==1)
                    {
                        if(B[0]==1 && B[2]==1)
                        {
                            return 1;
                        }else if(A[1]==1 && C[1]==1)
                        {
                            return 1;
                        }else if(A[0]==1 && C[2]==1)
                        {
                            return 1;
                        }else if(A[2]==1 && C[0]==1)
                        {
                            return 1;
                        }
                    }
                    if(column==2)
                    {
                        if(B[0]==1 && B[1]==1)
                        {
                            return 1;
                        }else if(A[2]==1 && C[2]==1)
                        {
                            return 1;
                        }
                    }
                }else{
                    B[column]=2;
                    if(column==0)
                    {
                        if(B[1]==2 && B[2]==2)
                        {
                            return 2;
                        }else if(A[0]==2 && C[0]==2)
                        {
                            return 2;
                        }
                    }
                    if(column==1)
                    {
                        if(B[0]==2 && B[2]==2)
                        {
                            return 2;
                        }else if(A[1]==2 && C[1]==2)
                        {
                            return 2;
                        }else if(A[0]==2 && C[2]==2)
                        {
                            return 2;
                        }else if(A[2]==2 && C[0]==2)
                        {
                            return 2;
                        }
                    }
                    if(column==2)
                    {
                        if(B[0]==2 && B[1]==2)
                        {
                            return 2;
                        }else if(A[2]==2 && C[2]==2)
                        {
                            return 2;
                        }
                    }
                }
            }
        }else{
            if(c[column]==1)
            {
                return 3;
            }else{
                c[column]=1;
                if(player==1)
                {
                    C[column]=1;
                    if(column==0)
                    {
                        if(C[1]==1 && C[2]==1)
                        {
                            return 1;
                        }else if(A[0]==1 && B[0]==1)
                        {
                            return 1;
                        }else if(A[2]==1 && B[1]==1)
                        {
                            return 1;
                        }
                    }
                    if(column==1)
                    {
                        if(C[0]==1 && C[2]==1)
                        {
                            return 1;
                        }else if(A[1]==1 && B[1]==1)
                        {
                            return 1;
                        }
                    }
                    if(column==2)
                    {
                        if(C[0]==1 && C[1]==1)
                        {
                            return 1;
                        }else if(A[2]==1 && B[2]==1)
                        {
                            return 1;
                        }else if(A[0]==1 && B[1]==1)
                        {
                            return 1;
                        }
                    }
                }else{
                    C[column]=2;
                    if(column==0)
                    {
                        if(C[1]==2 && C[2]==2)
                        {
                            return 2;
                        }else if(A[0]==2 && B[0]==2)
                        {
                            return 2;
                        }else if(A[2]==2 && B[1]==2)
                        {
                            return 2;
                        }
                    }
                    if(column==1)
                    {
                        if(C[0]==2 && C[2]==2)
                        {
                            return 2;
                        }else if(A[1]==2 && B[1]==2)
                        {
                            return 2;
                        }
                    }
                    if(column==2)
                    {
                        if(C[0]==2 && C[1]==2)
                        {
                            return 2;
                        }else if(A[2]==2 && B[2]==2)
                        {
                            return 2;
                        }else if(A[0]==2 && B[1]==2)
                        {
                            return 2;
                        }
                    }
                }
            }
        }

        return 0;
    }
}