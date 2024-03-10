public class AplikasiTodolist {
    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);


    public static void main(String[] args) {
        viewShowTodolist();
    }

    /**
     * Menampilkan todo list
     */
    public static void showTodoList() {
        System.out.println("TODOLIST");
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodolist(){
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi Kasus Java Dasar : Aplikasi Todolist";
        model[2] = "Belajar Java Lanjutan";
        showTodoList();
    }

    /**
     * Menambahkan todo ke list
     */
    public static void addTodolist(String todo) {
        // cek apakah model penuh
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                // model masih ada yang kosong
                isFull = false;
                break;
            }
        }

        // jika penuh, kita resize ukuran array 2x lipat
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // tambahkan ke posisi yang data array null
        for (var i = 0; i < model.length; i++) {
            if(model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        for (int i = 0; i <= 25; i++) {
            addTodolist("Contoh Todo Ke- " + i);
        }
        showTodoList();
    }

    /**
     * Menghapus todo dari list
     */
    public static boolean removeTodolist(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1]  == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList() {
        addTodolist("Satu");
        addTodolist("Dua");
        addTodolist("Tiga");
        addTodolist("Empat");
        addTodolist("Lima");

        var result = removeTodolist(20);
        System.out.println(result);

        result = removeTodolist(7);
        System.out.println(result);

        result = removeTodolist(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var name = input("Nama");
        System.out.println("Hi " + name);

        var channel = input("Channel");
        System.out.println(channel);
    }
    /**
     * Menampilkan view todo list
     */
    public static void viewShowTodolist() {
        while (true) {
            showTodoList();

            System.out.println("MENU :");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");

            if (input.equals("1")) {
                viewAddTodolist();
            } else if (input.equals("2")) {
                viewRemoveTodolist();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak ada");
            }
        }
    }

    public static void testViewShowTodolist() {
        addTodolist("Satu");
        addTodolist("Dua");
        addTodolist("Tiga");
        addTodolist("Empat");
        addTodolist("Lima");

        viewShowTodolist();
    }

    /**
     * Menampilkan view menambahkan todo list
     */
    public static void viewAddTodolist() {
        System.out.println("MENAMBAH TODOLIST");
        var todo = input("Todo (x Jika Batal)");

        if (todo.equals("x")) {
            // batal
        } else {
            addTodolist(todo);
        }
    }

    public static void testViewAddTodoList() {
        addTodolist("Satu");
        addTodolist("Dua");
        viewAddTodolist();

        showTodoList();
    }

    /**
     * Menampilkan view menghapus todo list
     */
    public static void viewRemoveTodolist() {
        System.out.println("MENGHAPUS TODOLIST");

        var number = input("Nomor yang Dihapus (x Jika Batal)");

        if (number.equals("x")) {
            // batal
        } else {
            boolean success = removeTodolist(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus todolist : " + number);
            }
        }
    }

    public static void testViewRemoveTodoList() {
        addTodolist("Satu");
        addTodolist("Dua");
        addTodolist("Tiga");

        showTodoList();

        viewRemoveTodolist();

        showTodoList();
    }
}
