namespace NewTelDesktopApp
{
    partial class HornitzaileakForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(HornitzaileakForm));
            this.label1 = new System.Windows.Forms.Label();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.buttonAtzeraBezeroak = new System.Windows.Forms.Button();
            this.kontrolaHornitzaile11 = new HornitzaileenDll1.KontrolaHornitzaile1();
            this.kontrolaHornitzaile21 = new HornitzaileenDll2.KontrolaHornitzaile2();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.labelKant = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.tableAdapterManager1 = new HornitzaileKantitateaDll.NewTelDataSetTableAdapters.TableAdapterManager();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Verdana", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.Crimson;
            this.label1.Location = new System.Drawing.Point(195, 53);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(318, 38);
            this.label1.TabIndex = 3;
            this.label1.Text = "HORNITZAILEAK";
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = global::NewTelDesktopApp.Properties.Resources.hornitzaileak;
            this.pictureBox1.Location = new System.Drawing.Point(102, 21);
            this.pictureBox1.Margin = new System.Windows.Forms.Padding(2);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(75, 81);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 2;
            this.pictureBox1.TabStop = false;
            // 
            // buttonAtzeraBezeroak
            // 
            this.buttonAtzeraBezeroak.BackColor = System.Drawing.Color.Black;
            this.buttonAtzeraBezeroak.FlatAppearance.BorderColor = System.Drawing.Color.Crimson;
            this.buttonAtzeraBezeroak.FlatAppearance.BorderSize = 2;
            this.buttonAtzeraBezeroak.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonAtzeraBezeroak.ForeColor = System.Drawing.Color.White;
            this.buttonAtzeraBezeroak.Location = new System.Drawing.Point(974, 611);
            this.buttonAtzeraBezeroak.Name = "buttonAtzeraBezeroak";
            this.buttonAtzeraBezeroak.Size = new System.Drawing.Size(101, 46);
            this.buttonAtzeraBezeroak.TabIndex = 8;
            this.buttonAtzeraBezeroak.Text = "ATZERA";
            this.buttonAtzeraBezeroak.UseVisualStyleBackColor = false;
            this.buttonAtzeraBezeroak.Click += new System.EventHandler(this.ButtonAtzeraBezeroak_Click);
            // 
            // kontrolaHornitzaile11
            // 
            this.kontrolaHornitzaile11.Location = new System.Drawing.Point(79, 275);
            this.kontrolaHornitzaile11.Name = "kontrolaHornitzaile11";
            this.kontrolaHornitzaile11.Size = new System.Drawing.Size(390, 225);
            this.kontrolaHornitzaile11.TabIndex = 9;
            // 
            // kontrolaHornitzaile21
            // 
            this.kontrolaHornitzaile21.Location = new System.Drawing.Point(610, 275);
            this.kontrolaHornitzaile21.Name = "kontrolaHornitzaile21";
            this.kontrolaHornitzaile21.Size = new System.Drawing.Size(390, 225);
            this.kontrolaHornitzaile21.TabIndex = 10;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.labelKant);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.groupBox1.Location = new System.Drawing.Point(79, 125);
            this.groupBox1.Margin = new System.Windows.Forms.Padding(2);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Padding = new System.Windows.Forms.Padding(2);
            this.groupBox1.Size = new System.Drawing.Size(370, 81);
            this.groupBox1.TabIndex = 11;
            this.groupBox1.TabStop = false;
            // 
            // labelKant
            // 
            this.labelKant.AutoSize = true;
            this.labelKant.Font = new System.Drawing.Font("Microsoft Sans Serif", 26.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelKant.ForeColor = System.Drawing.Color.Snow;
            this.labelKant.Location = new System.Drawing.Point(212, 24);
            this.labelKant.Name = "labelKant";
            this.labelKant.Size = new System.Drawing.Size(57, 39);
            this.labelKant.TabIndex = 1;
            this.labelKant.Text = "14";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.ForeColor = System.Drawing.Color.Snow;
            this.label2.Location = new System.Drawing.Point(20, 33);
            this.label2.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(196, 17);
            this.label2.TabIndex = 0;
            this.label2.Text = "HORNITZAILE KANTITATEA: ";
            // 
            // tableAdapterManager1
            // 
            this.tableAdapterManager1.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager1.Connection = null;
            this.tableAdapterManager1.product_productTableAdapter = null;
            this.tableAdapterManager1.purchase_order_lineTableAdapter = null;
            this.tableAdapterManager1.purchase_orderTableAdapter = null;
            this.tableAdapterManager1.res_partnerTableAdapter = null;
            this.tableAdapterManager1.sale_order_lineTableAdapter = null;
            this.tableAdapterManager1.sale_orderTableAdapter = null;
            this.tableAdapterManager1.UpdateOrder = HornitzaileKantitateaDll.NewTelDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // HornitzaileakForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.ClientSize = new System.Drawing.Size(1112, 693);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.kontrolaHornitzaile21);
            this.Controls.Add(this.kontrolaHornitzaile11);
            this.Controls.Add(this.buttonAtzeraBezeroak);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.label1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "HornitzaileakForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "HornitzaileakForm";
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button buttonAtzeraBezeroak;
        private HornitzaileenDll1.KontrolaHornitzaile1 kontrolaHornitzaile11;
        private HornitzaileenDll2.KontrolaHornitzaile2 kontrolaHornitzaile21;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Label labelKant;
        private System.Windows.Forms.Label label2;
        private HornitzaileKantitateaDll.NewTelDataSetTableAdapters.TableAdapterManager tableAdapterManager1;
    }
}