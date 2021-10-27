using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

#nullable disable

namespace DbModelAdibidea.Models
{
    public partial class MyDBContext : DbContext
    {
        public MyDBContext()
        {
        }

        public MyDBContext(DbContextOptions<MyDBContext> options)
            : base(options)
        {
        }

        public virtual DbSet<Bezeroa> Bezeroa { get; set; }
        public virtual DbSet<Salmenta> Salmenta { get; set; }
        public virtual DbSet<Saltzailea> Saltzailea { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
                optionsBuilder.UseSqlServer("Server=UH-004-08\\SQLEXPRESS;Database=SalmentaDB;user=sa;password=Admin123");
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.HasAnnotation("Relational:Collation", "Modern_Spanish_CI_AS");

            modelBuilder.Entity<Bezeroa>(entity =>
            {
                entity.HasKey(e => e.Nan);

                entity.ToTable("BEZEROA");

                entity.Property(e => e.Nan)
                    .HasMaxLength(9)
                    .HasColumnName("NAN")
                    .IsFixedLength(true);

                entity.Property(e => e.Emaila)
                    .HasMaxLength(50)
                    .HasColumnName("EMAILA")
                    .IsFixedLength(true);

                entity.Property(e => e.Helbidea)
                    .HasMaxLength(50)
                    .HasColumnName("HELBIDEA")
                    .IsFixedLength(true);

                entity.Property(e => e.Izena)
                    .HasMaxLength(50)
                    .HasColumnName("IZENA")
                    .IsFixedLength(true);

                entity.Property(e => e.Nansaltzailea)
                    .HasMaxLength(9)
                    .HasColumnName("NANSALTZAILEA")
                    .IsFixedLength(true);

                entity.Property(e => e.Telf)
                    .HasMaxLength(9)
                    .HasColumnName("TELF")
                    .IsFixedLength(true);

                entity.HasOne(d => d.NansaltzaileaNavigation)
                    .WithMany(p => p.Bezeroa)
                    .HasForeignKey(d => d.Nansaltzailea)
                    .HasConstraintName("FK_BEZEROA_BEZEROA");
            });

            modelBuilder.Entity<Salmenta>(entity =>
            {
                entity.ToTable("SALMENTA");

                entity.Property(e => e.Id)
                    .HasColumnType("numeric(18, 0)")
                    .HasColumnName("ID");

                entity.Property(e => e.Data)
                    .HasColumnType("date")
                    .HasColumnName("DATA");

                entity.Property(e => e.Nanbezeroa)
                    .HasMaxLength(9)
                    .HasColumnName("NANBEZEROA")
                    .IsFixedLength(true);

                entity.Property(e => e.Zenbatekoa).HasColumnName("ZENBATEKOA");

                entity.HasOne(d => d.NanbezeroaNavigation)
                    .WithMany(p => p.Salmenta)
                    .HasForeignKey(d => d.Nanbezeroa)
                    .HasConstraintName("FK_Salmenta_BEZEROA");
            });

            modelBuilder.Entity<Saltzailea>(entity =>
            {
                entity.HasKey(e => e.Nan)
                    .HasName("PK_Saltzailea");

                entity.ToTable("SALTZAILEA");

                entity.Property(e => e.Nan)
                    .HasMaxLength(9)
                    .HasColumnName("NAN")
                    .IsFixedLength(true);

                entity.Property(e => e.Izena)
                    .HasMaxLength(50)
                    .HasColumnName("IZENA")
                    .IsFixedLength(true);

                entity.Property(e => e.Taldea)
                    .HasMaxLength(10)
                    .HasColumnName("TALDEA")
                    .IsFixedLength(true);
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
