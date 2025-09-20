$ErrorActionPreference = 'Stop'
$root = Split-Path -Parent $MyInvocation.MyCommand.Path
Get-ChildItem -Path $root -Filter *.java -Recurse | ForEach-Object {
  $p = $_.FullName
  $lines = Get-Content -LiteralPath $p
  $filtered = $lines | Where-Object { $_ -notmatch '^\s*\*\s*@author\b' -and $_ -notmatch '^\s*\*\s*@github\b' }
  Set-Content -LiteralPath $p -Encoding UTF8 -Value $filtered
}