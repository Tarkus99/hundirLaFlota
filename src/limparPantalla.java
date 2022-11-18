public class limparPantalla {
        public static void limpiar()
        {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
