public class Each_State {

    public Crawl_Link Seek_link;

    public Each_State(Crawl_Link Seek_link)
    {
        this.Seek_link = Seek_link;
    }


    public void runACT()
    {
        /**
         * run ACT
         */
        Boolean runACT = true;
        int iACT = 1;
        while (runACT) {
            runACT = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-ACT?page=" + iACT);
            iACT++;

            try {
                if (iACT % 10 == 0) {
                    Thread.sleep(1000);
                    System.out.println("have a reset sleep, ACT");
                }
            } catch (Exception et) {
                System.out.println("iact sleep");
                et.printStackTrace();
            }
        }
    }


    public void runNSW()
    {
        /**
         * run NSW
         */
        Boolean runNSW = true;
        int iNSW = 1;
        while(runNSW)
        {
            runNSW = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-NSW?page=" + iNSW);
            iNSW ++;

            try
            {
                if(iNSW % 10 == 0)
                {
                    Thread.sleep(1000);
                    System.out.println("have a reset sleep, iNSW");
                }
            }
            catch (Exception et)
            {
                System.out.println("iNSW sleep");
                et.printStackTrace();
            }
        }
    }

    public void runNT()
    {
        /**
         * run NT
         */
        Boolean runNT = true;
        int iNT = 1;
        while(runNT)
        {
            runNT = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-NT?page=" + iNT);
            iNT ++;

            try
            {
                if(iNT % 10 == 0)
                {
                    System.out.println("have a reset sleep, NT");
                    Thread.sleep(1000);
                }
            }
            catch (Exception et)
            {
                System.out.println("iNT sleep");
                et.printStackTrace();
            }
        }
    }

    public void runQLD()
    {
        /**
         * run QLD
         */
        Boolean runQLD = true;
        int iQLD = 1;
        while(runQLD)
        {
            runQLD = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-QLD?page=" + iQLD);
            iQLD ++;

            try
            {
                if(iQLD % 10 == 0)
                {
                    System.out.println("have a reset sleep, iQLD");
                    Thread.sleep(1000);
                }
            }
            catch (Exception et)
            {
                System.out.println("iQLD sleep");
                et.printStackTrace();
            }
        }

    }

    public void runSA()
    {
        /**
         * run sa
         */
        Boolean runSA = true;
        int iSA = 1;
        while(runSA)
        {

            runSA = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-SA?page=" + iSA);
            iSA ++;
            try
            {
                if(iSA % 10 == 0)
                {
                    System.out.println("have a reset sleep, QLD");
                    Thread.sleep(1000);
                }
            }
            catch (Exception et)
            {
                System.out.println("iQLD sleep");
                et.printStackTrace();
            }
        }
    }

    public void runTAS()
    {
        /**
         * run tas
         */
        Boolean runTAS = true;
        int iTAS = 1;
        while(runTAS)
        {

            runTAS = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-TAS?page=" + iTAS);
            iTAS ++;

            try
            {
                if(iTAS % 10 == 0)
                {
                    System.out.println("have a reset sleep, TAS");
                    Thread.sleep(1000);
                }
            }
            catch (Exception et)
            {
                System.out.println("iTAS sleep");
                et.printStackTrace();
            }
        }
    }

    public void runVIC()
    {
        /**
         * run VIC
         */

        Boolean runVIC = true;
        int iVIC = 1;
        while(runVIC)
        {
            runVIC = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-VIC?page=" + iVIC);
            iVIC ++;

            try
            {
                if(iVIC % 10 == 0)
                {
                    System.out.println("have a reset sleep, VIC");
                    Thread.sleep(1000);
                }
            }
            catch (Exception et)
            {
                System.out.println("iVIC sleep");
                et.printStackTrace();
            }
        }
    }

    public void runWA()
    {
        /**
         * run WA
         */

        Boolean runWA = true;
        int iWA = 1;
        while(runWA)
        {
            runWA = Seek_link.Crawlit("https://www.seek.com.au/jobs-in-information-communication-technology/in-WA?page=" + iWA);
            iWA ++;

            try
            {
                if(iWA % 10 == 0)
                {
                    System.out.println("have a reset sleep, WA");
                    Thread.sleep(1000);
                }
            }
            catch (Exception et)
            {
                System.out.println("iWA sleep");
                et.printStackTrace();
            }
        }
    }






}