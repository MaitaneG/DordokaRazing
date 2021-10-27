using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;

#nullable disable

namespace DbModelAdibidea.Models
{
    [Table("BEZEROA")]
    public partial class Bezeroa    {
        
        public Bezeroa()
        {
            Salmenta = new HashSet<Salmenta>();
        }

        public string Nan { get; set; }
        public string Izena { get; set; }
        public string Helbidea { get; set; }
        public string Telf { get; set; }
        public string Emaila { get; set; }
        public string Nansaltzailea { get; set; }

        public virtual Saltzailea NansaltzaileaNavigation { get; set; }
        public virtual ICollection<Salmenta> Salmenta { get; set; }
    }
}
