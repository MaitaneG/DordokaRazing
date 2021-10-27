namespace NewTelDesktopApp
{
    partial class MenuaForm
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(MenuaForm));
            this.buttonFinantzak = new System.Windows.Forms.Button();
            this.buttonBezeroa = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.buttonAtzeraMenua = new System.Windows.Forms.Button();
            this.buttonHornitzaileak = new System.Windows.Forms.Button();
            this.linkLabel1 = new System.Windows.Forms.LinkLabel();
            this.SuspendLayout();
            // 
            // buttonFinantzak
            // 
            this.buttonFinantzak.BackColor = System.Drawing.Color.Black;
            this.buttonFinantzak.FlatAppearance.BorderColor = System.Drawing.Color.Red;
            this.buttonFinantzak.FlatAppearance.BorderSize = 2;
            this.buttonFinantzak.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonFinantzak.ForeColor = System.Drawing.Color.White;
            this.buttonFinantzak.Location = new System.Drawing.Point(335, 196);
            this.buttonFinantzak.Name = "buttonFinantzak";
            this.buttonFinantzak.Size = new System.Drawing.Size(101, 46);
            this.buttonFinantzak.TabIndex = 1;
            this.buttonFinantzak.Text = "FINANTZAK";
            this.buttonFinantzak.UseVisualStyleBackColor = false;
            this.buttonFinantzak.Click += new System.EventHandler(this.botoiak);
            // 
            // buttonBezeroa
            // 
            this.buttonBezeroa.BackColor = System.Drawing.Color.Black;
            this.buttonBezeroa.FlatAppearance.BorderColor = System.Drawing.Color.Red;
            this.buttonBezeroa.FlatAppearance.BorderSize = 2;
            this.buttonBezeroa.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonBezeroa.ForeColor = System.Drawing.SystemColors.ControlLight;
            this.buttonBezeroa.Location = new System.Drawing.Point(176, 196);
            this.buttonBezeroa.Name = "buttonBezeroa";
            this.buttonBezeroa.Size = new System.Drawing.Size(101, 46);
            this.buttonBezeroa.TabIndex = 2;
            this.buttonBezeroa.Text = "BEZEROAK";
            this.buttonBezeroa.UseVisualStyleBackColor = false;
            this.buttonBezeroa.Click += new System.EventHandler(this.botoiak);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Verdana", 24F, System.Drawing.FontStyle.Bold);
            this.label1.ForeColor = System.Drawing.Color.Red;
            this.label1.Location = new System.Drawing.Point(166, 72);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(444, 38);
            this.label1.TabIndex = 3;
            this.label1.Text = "ZER IKUSI NAHI DUZU?";
            // 
            // buttonAtzeraMenua
            // 
            this.buttonAtzeraMenua.BackColor = System.Drawing.Color.Black;
            this.buttonAtzeraMenua.FlatAppearance.BorderColor = System.Drawing.Color.Red;
            this.buttonAtzeraMenua.FlatAppearance.BorderSize = 2;
            this.buttonAtzeraMenua.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonAtzeraMenua.ForeColor = System.Drawing.Color.White;
            this.buttonAtzeraMenua.Location = new System.Drawing.Point(675, 382);
            this.buttonAtzeraMenua.Name = "buttonAtzeraMenua";
            this.buttonAtzeraMenua.Size = new System.Drawing.Size(101, 46);
            this.buttonAtzeraMenua.TabIndex = 4;
            this.buttonAtzeraMenua.Text = "ATZERA";
            this.buttonAtzeraMenua.UseVisualStyleBackColor = false;
            this.buttonAtzeraMenua.Click += new System.EventHandler(this.botoiak);
            // 
            // buttonHornitzaileak
            // 
            this.buttonHornitzaileak.BackColor = System.Drawing.Color.Black;
            this.buttonHornitzaileak.FlatAppearance.BorderColor = System.Drawing.Color.Red;
            this.buttonHornitzaileak.FlatAppearance.BorderSize = 2;
            this.buttonHornitzaileak.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.buttonHornitzaileak.ForeColor = System.Drawing.Color.White;
            this.buttonHornitzaileak.Location = new System.Drawing.Point(497, 196);
            this.buttonHornitzaileak.Name = "buttonHornitzaileak";
            this.buttonHornitzaileak.Size = new System.Drawing.Size(113, 46);
            this.buttonHornitzaileak.TabIndex = 5;
            this.buttonHornitzaileak.Text = "HORNITZAILEAK";
            this.buttonHornitzaileak.UseVisualStyleBackColor = false;
            this.buttonHornitzaileak.Click += new System.EventHandler(this.botoiak);
            // 
            // linkLabel1
            // 
            this.linkLabel1.AutoSize = true;
            this.linkLabel1.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.linkLabel1.LinkColor = System.Drawing.Color.Red;
            this.linkLabel1.Location = new System.Drawing.Point(320, 364);
            this.linkLabel1.Name = "linkLabel1";
            this.linkLabel1.Size = new System.Drawing.Size(152, 18);
            this.linkLabel1.TabIndex = 7;
            this.linkLabel1.TabStop = true;
            this.linkLabel1.Text = "ODOO ZERBITZARIA";
            this.linkLabel1.VisitedLinkColor = System.Drawing.Color.Maroon;
            this.linkLabel1.LinkClicked += new System.Windows.Forms.LinkLabelLinkClickedEventHandler(this.linkLabel1_LinkClicked);
            // 
            // MenuaForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.linkLabel1);
            this.Controls.Add(this.buttonHornitzaileak);
            this.Controls.Add(this.buttonAtzeraMenua);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.buttonBezeroa);
            this.Controls.Add(this.buttonFinantzak);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "MenuaForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Menua";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Button buttonFinantzak;
        private System.Windows.Forms.Button buttonBezeroa;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button buttonAtzeraMenua;
        private System.Windows.Forms.Button buttonHornitzaileak;
        private System.Windows.Forms.LinkLabel linkLabel1;
    }
}