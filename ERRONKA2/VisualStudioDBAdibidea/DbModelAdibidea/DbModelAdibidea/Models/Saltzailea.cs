using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;

#nullable disable

namespace DbModelAdibidea.Models
{
    [Table("SALTZAILEA")]
    public partial class Saltzailea
    {
        public Saltzailea()
        {
            Bezeroa = new HashSet<Bezeroa>();
        }

        public string Nan { get; set; }
        public string Izena { get; set; }
        public string Taldea { get; set; }

        public virtual ICollection<Bezeroa> Bezeroa { get; set; }
    }
}
