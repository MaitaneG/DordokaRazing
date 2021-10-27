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
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
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
            // HornitzaileakForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.ClientSize = new System.Drawing.Size(1112, 693);
            this.Controls.Add(this.buttonAtzeraBezeroak);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.label1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "HornitzaileakForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "HornitzaileakForm";
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button buttonAtzeraBezeroak;
    }
}