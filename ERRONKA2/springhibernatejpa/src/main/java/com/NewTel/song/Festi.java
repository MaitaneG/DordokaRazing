package com.NewTel.song;

public class Festi extends Thread{
    public static Kick kick = new Kick();
    public static Snare snare = new Snare();
    public static Hat hat = new Hat();
    public static Melo melo = new Melo();

    @Override
    public void run() {
        super.run();
        kick.setPriority(Thread.MAX_PRIORITY);
        kick.start();
        kick.interrupt();
        hat.start();
        hat.interrupt();
        snare.start();
        snare.interrupt();
        //melo.start();
        //melo.interrupt();
        for (int x = 0; x < 7; x++) {
            kick.run();
            kick.interrupt();
            for (int i = 0; i < 2; i++) {
                hat.run();

                hat.interrupt();
            }


            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //snare.run();
            //hat.run();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        kick.run();
        kick.interrupt();
        hat.run();
        hat.interrupt();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            hat.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        snare.run();
        try {
            snare.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hat.run();

        hat.interrupt();
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        snare.run();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int x = 0; x < 16; x++) {
            if (x == 8) {
                kick.run();
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            kick.run();
            kick.interrupt();
            for (int i = 0; i < 2; i++) {
                hat.run();

                hat.interrupt();
            }
            if (x == 8) {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            snare.run();
            //hat.run();
            if (x == 3 || x == 7 || x == 15 || x == 11) {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                snare.run();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        for (int x = 0; x < 16; x++) {
            if (x == 8) {
                kick.run();
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            kick.run();
            kick.interrupt();
            for (int i = 0; i < 2; i++) {
                hat.run();

                hat.interrupt();
            }
            if (x == 8) {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            snare.run();
            //hat.run();
            if (x == 3 || x == 7 || x == 15 || x == 11) {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                snare.run();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        //lead
        kick.run();
        kick.interrupt();
        melo.start();


        for (int x = 0; x < 16; x++) {
            if (x == 8) {
                kick.run();
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (x != 0) {
                kick.run();
                kick.interrupt();
            }

            for (int i = 0; i < 2; i++) {
                hat.run();

                hat.interrupt();
            }
            if (x == 8) {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            snare.run();
            //hat.run();
            if (x == 3 || x == 7 || x == 15 || x == 11) {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                snare.run();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
