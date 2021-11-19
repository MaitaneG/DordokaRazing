using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BezeroakGuztiraDll
{
    public partial class KontrrolaBezGuztira : UserControl
    {
        NewTelDataSet kontrolDataSet = new NewTelDataSet();
        public KontrrolaBezGuztira()
        {
            InitializeComponent();
            
            NewTelDataSetTableAdapters.res_partnerTableAdapter salmentaTableAdapter = new NewTelDataSetTableAdapters.res_partnerTableAdapter();
            

            salmentaTableAdapter.Fill(this.kontrolDataSet.res_partner);
            
           

            //kontrolDataSet.res_partner
            //    .GroupBy(p => p.create_date.ToShortDateString())
            //    .Select(i => new { create_date = i.Key, egunBakoitzeko = i.Count() });



        }
        public string ateraKantitatea()
        {
            res_partnerTableAdapter.Fill(this.kontrolDataSet.res_partner);
            return res_partnerTableAdapter.BezeroKant().ToString();
        }
    }
}
