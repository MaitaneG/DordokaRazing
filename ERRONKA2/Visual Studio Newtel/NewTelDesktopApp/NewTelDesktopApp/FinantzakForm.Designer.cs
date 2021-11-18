namespace NewTelDesktopApp
{
    partial class FinantzakForm
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FinantzakForm));
            this.label1 = new System.Windows.Forms.Label();
            this.buttonAtzeraBezeroak = new System.Windows.Forms.Button();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.kontrolaFinantzak11 = new FinantzetakoDll1.KontrolaFinantzak1();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.labelSalduEuro = new System.Windows.Forms.Label();
            this.labelErosiEuro = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.labelTotala = new System.Windows.Forms.Label();
            this.kontrolaFinantzak21 = new FinantzetakoDll2.KontrolaFinantzak2();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Verdana", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.Gold;
            this.label1.Location = new System.Drawing.Point(190, 42);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(228, 38);
            this.label1.TabIndex = 3;
            this.label1.Text = "FINANTZAK";
            // 
            // buttonAtzeraBezeroak
            // 
            this.buttonAtzeraBezeroak.BackColor = System.Drawing.Color.Black;
            this.buttonAtzeraBezeroak.FlatAppearance.BorderColor = System.Drawing.Color.Goldenrod;
            this.buttonAtzeraBezeroak.FlatAppearance.BorderSize = 2;
            this.buttonAtzeraBezeroak.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonAtzeraBezeroak.ForeColor = System.Drawing.Color.White;
            this.buttonAtzeraBezeroak.Location = new System.Drawing.Point(974, 611);
            this.buttonAtzeraBezeroak.Name = "buttonAtzeraBezeroak";
            this.buttonAtzeraBezeroak.Size = new System.Drawing.Size(101, 46);
            this.buttonAtzeraBezeroak.TabIndex = 7;
            this.buttonAtzeraBezeroak.Text = "ATZERA";
            this.buttonAtzeraBezeroak.UseVisualStyleBackColor = false;
            this.buttonAtzeraBezeroak.Click += new System.EventHandler(this.ButtonAtzeraBezeroak_Click);
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = global::NewTelDesktopApp.Properties.Resources.finantzak;
            this.pictureBox1.Location = new System.Drawing.Point(102, 21);
            this.pictureBox1.Margin = new System.Windows.Forms.Padding(2);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(75, 81);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 2;
            this.pictureBox1.TabStop = false;
            // 
            // kontrolaFinantzak11
            // 
            this.kontrolaFinantzak11.Location = new System.Drawing.Point(82, 184);
            this.kontrolaFinantzak11.Name = "kontrolaFinantzak11";
            this.kontrolaFinantzak11.Size = new System.Drawing.Size(390, 225);
            this.kontrolaFinantzak11.TabIndex = 8;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.ForeColor = System.Drawing.Color.White;
            this.label2.Location = new System.Drawing.Point(630, 421);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(326, 20);
            this.label2.TabIndex = 10;
            this.label2.Text = "SALMENTEN ZENBATEKOA GUZTIRA:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.ForeColor = System.Drawing.Color.White;
            this.label3.Location = new System.Drawing.Point(86, 421);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(332, 20);
            this.label3.TabIndex = 11;
            this.label3.Text = "EROSKETEN ZENBATEKOA GUZTIRA: ";
            // 
            // labelSalduEuro
            // 
            this.labelSalduEuro.AutoSize = true;
            this.labelSalduEuro.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelSalduEuro.ForeColor = System.Drawing.Color.White;
            this.labelSalduEuro.Location = new System.Drawing.Point(962, 421);
            this.labelSalduEuro.Name = "labelSalduEuro";
            this.labelSalduEuro.Size = new System.Drawing.Size(0, 20);
            this.labelSalduEuro.TabIndex = 12;
            // 
            // labelErosiEuro
            // 
            this.labelErosiEuro.AutoSize = true;
            this.labelErosiEuro.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelErosiEuro.ForeColor = System.Drawing.Color.White;
            this.labelErosiEuro.Location = new System.Drawing.Point(424, 421);
            this.labelErosiEuro.Name = "labelErosiEuro";
            this.labelErosiEuro.Size = new System.Drawing.Size(0, 20);
            this.labelErosiEuro.TabIndex = 13;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.ForeColor = System.Drawing.Color.White;
            this.label4.Location = new System.Drawing.Point(282, 531);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(324, 20);
            this.label4.TabIndex = 14;
            this.label4.Text = "ENPRESAREN IRABAZIAK GUZTIRA: ";
            // 
            // labelTotala
            // 
            this.labelTotala.AutoSize = true;
            this.labelTotala.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelTotala.ForeColor = System.Drawing.Color.White;
            this.labelTotala.Location = new System.Drawing.Point(602, 531);
            this.labelTotala.Name = "labelTotala";
            this.labelTotala.Size = new System.Drawing.Size(0, 20);
            this.labelTotala.TabIndex = 15;
            // 
            // kontrolaFinantzak21
            // 
            this.kontrolaFinantzak21.Location = new System.Drawing.Point(606, 184);
            this.kontrolaFinantzak21.Name = "kontrolaFinantzak21";
            this.kontrolaFinantzak21.Size = new System.Drawing.Size(390, 225);
            this.kontrolaFinantzak21.TabIndex = 16;
            // 
            // FinantzakForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.ClientSize = new System.Drawing.Size(1112, 693);
            this.Controls.Add(this.kontrolaFinantzak21);
            this.Controls.Add(this.labelTotala);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.labelErosiEuro);
            this.Controls.Add(this.labelSalduEuro);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.kontrolaFinantzak11);
            this.Controls.Add(this.buttonAtzeraBezeroak);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.label1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "FinantzakForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Finantzak";
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button buttonAtzeraBezeroak;
        private FinantzetakoDll1.KontrolaFinantzak1 kontrolaFinantzak11;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label labelSalduEuro;
        private System.Windows.Forms.Label labelErosiEuro;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label labelTotala;
        private FinantzetakoDll2.KontrolaFinantzak2 kontrolaFinantzak21;
    }
}