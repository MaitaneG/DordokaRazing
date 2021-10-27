using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;

#nullable disable

namespace DbModelAdibidea.Models
{
    [Table("SALMENTA")]
    public partial class Salmenta
    {
        public decimal Id { get; set; }
        public DateTime? Data { get; set; }
        public double? Zenbatekoa { get; set; }
        public string Nanbezeroa { get; set; }

        public virtual Bezeroa NanbezeroaNavigation { get; set; }
    }
}
