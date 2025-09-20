$ErrorActionPreference = 'Stop'
$root = Split-Path -Parent $MyInvocation.MyCommand.Path

# Clean Java files: remove local Windows paths, author names, and rebrand
Get-ChildItem -Path $root -Filter *.java -Recurse | ForEach-Object {
  $p = $_.FullName
  $lines = Get-Content -LiteralPath $p
  $out = @()
  foreach ($line in $lines) {
    # Drop any line that contains any local user path (e.g., C:\Users\...)
    if ($line -match 'C:\\Users\\') { continue }

    # Drop or neutralize hardcoded sample arrays revealing names
    if ($line -match '(?i)private\s+String\s+user\[\]\s*=') { continue }
    if ($line -match '(?i)private\s+String\s+pass\[\]\s*=') { continue }

    # Remove leftover personal name tokens anywhere
    if ($line -match '(?i)soumyadip|soumyadeep|soumya') { $line = ($line -replace '(?i)soumyadip|soumyadeep|soumya','admin') }

    # Replace project title branding
    $line = $line -replace 'Book Hub','Book Selling System'

    # Replace hardcoded admin test creds/names
    $line = $line -replace '"Soumya"','"admin"'
    $line = $line -replace '"1234"','"admin123"'

    $out += $line
  }
  Set-Content -LiteralPath $p -Encoding UTF8 -Value $out
}

# Clean SQL file email
$sqlPath = Join-Path $root 'create_database.sql'
if (Test-Path $sqlPath) {
  $sql = Get-Content -LiteralPath $sqlPath -Raw
  $sql = $sql -replace '(?i)admin@bookhub\.com','admin@example.com'
  Set-Content -LiteralPath $sqlPath -Encoding UTF8 -Value $sql
}
