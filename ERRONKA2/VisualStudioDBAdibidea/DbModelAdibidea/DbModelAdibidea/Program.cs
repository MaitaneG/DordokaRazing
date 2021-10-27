using DbModelAdibidea.Models;
using System;
using System.Collections.Generic;
using System.Linq;

namespace DbModelAdibidea
{
    class Program
    {
        static void Main(string[] args)
        {
            Proba();
        }
        static void Proba()
        {
            var db = new MyDBContext();
            List<Saltzailea> saltzaileak = db.Saltzailea.ToList();

            foreach(Saltzailea s in saltzaileak)
            {
                Console.WriteLine(s.Izena.Trim()+ " saltzaileak hurrengo bezeroak ditu:");
                //List<Bezeroa> bezSaltzaileko = db.Bezeroa.Select().where;
                var bSaltzaileko= db.Bezeroa.Where(b => b.Nansaltzailea==s.Nan).ToList();
                foreach (Bezeroa b in bSaltzaileko)
                {
                    Console.WriteLine("\t"+b.Izena.Trim() + " bezeroak hurrengo eskariak egin ditu: ");
                    var sBezeroko = db.Salmenta.Where(e => e.Nanbezeroa == b.Nan).ToList();
                    foreach (Salmenta e in sBezeroko)
                    {
                        Console.WriteLine("\t\tID: "+e.Id);
                        Console.WriteLine("\t\tData: " + e.Data);
                    }
                }
            }
           
        }
    }
}
